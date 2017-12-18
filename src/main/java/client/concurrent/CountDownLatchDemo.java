package client.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 多线程并发倒计时工具类
 * @author wsp
 * @since 2017/09/05
 */
public class CountDownLatchDemo {


    public static void main(String[] args) {
        final int tNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(tNum);//创建CountDownLatch对象,共享锁模式,最多可以有10个线程获取锁
        ExecutorService executor = Executors.newFixedThreadPool(tNum);//创建一个固定大小的线程池
        for(int i = 0 ;i <tNum; i++){
            executor.execute(new Person(i+1,countDownLatch,Thread.currentThread()));
        }
        System.out.println("wait person sign!");
        try {
            countDownLatch.await(2000,TimeUnit.MILLISECONDS);//倒计时等待所有子线程执行完签到
            System.out.println("sign finish start eat!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }



    private static class Person implements Runnable{
        private int index;
        private CountDownLatch countDownLatch;
        private Thread thread;

        public Person(){

        }

        public Person(int index,CountDownLatch countDownLatch,Thread thread){
             this.index = index;
             this.countDownLatch = countDownLatch;
             this.thread = thread;
        }

        @Override
        public void run() {
           try {
               Thread.sleep(3000);
           }catch (Exception e){
               e.printStackTrace();
           }
           System.out.println(Thread.currentThread()+"execute sign,person index is : " + index);
           countDownLatch.countDown();
        }
    }


}
