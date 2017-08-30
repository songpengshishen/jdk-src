package client.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * JDK中读锁与写锁,实现了类似于DBMS中事务的排他锁(写锁)和共享锁(读锁)
 * @author wsp
 * @since 2017/08/30
 */
public class ReadAndWriteLock {
  //jdk中的读写锁,提升多线程在读取时的并发,并行性能.
  private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
  //多个线程的共享集合
  private List<String> list = new ArrayList<String>();

  public ReadAndWriteLock(){
      list.add("1");
      list.add("2");
      list.add("3");
  }


    /**
     * 读锁类似于数据库中的共享锁,当一个线程获取到读锁,其他线程可以继续获取到读锁,但是不可以获取写锁,只有读锁释放了,才可以获取写锁.
     * 所以获取到读锁只可以进行读操作和继续获取读锁.不能获取写锁执行写操作.
     * @param index
     * @return
     */
  public String get(int index){
    //获取读锁并上锁
    Lock rlock =  readWriteLock.readLock();
    rlock.lock();
    try {
            System.out.println(Thread.currentThread().getName()+"获取到读锁");
            String str =  list.get(index);
            System.out.println(Thread.currentThread().getName()+"读到的值:"+str);

            return str;
    }finally {
        //手动释放锁,否则异常时锁不被释放会导致,线程饥饿。
        rlock.unlock();
    }
  }

    /**
     * 写锁类似于数据库中的排它锁,当一个线程获取到写锁,只有这个线程可以进行操作,其他线程都要阻塞到线程释放了写锁,并且其他线程都不能再次获取读锁和写锁.
     * @param str
     */
  public void put(String str){
        //获取写锁并上锁
        Lock wlock =  readWriteLock.writeLock();
        wlock.lock();
        try {
             System.out.println(Thread.currentThread().getName()+"获取到写锁");
             list.add(str);
             System.out.println(Thread.currentThread().getName()+"插入成功的值:"+str);
        }finally {
            //手动释放锁,否则异常时锁不被释放会导致,线程饥饿。
            wlock.unlock();
        }
  }


  public static void main(String[] args){
      final ReadAndWriteLock rwLock  = new ReadAndWriteLock();
      Thread t1 = new Thread(new Runnable(){
          @Override
          public void run() {
              rwLock.put("4");
              rwLock.get(0);

          }
      });

      Thread t2 = new Thread(new Runnable(){

          @Override
          public void run() {
              rwLock.put("5");
              rwLock.get(0);
          }
      });


      Thread t3 = new Thread(new Runnable(){
          @Override
          public void run() {
              rwLock.get(0);
          }
      });

      t1.start();t2.start();t3.start();
  }
}
