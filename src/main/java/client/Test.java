package client;


import java.lang.reflect.Field;
import java.util.*;

/**
 *
 */
public class Test<T> {

   public static Object Lock = new Object();

    public static void main(String[] args) throws Exception {
       Thread t1 = new Thread(() -> {
           try {
               System.out.println("我在执行!");
               synchronized (Lock){
                   System.out.println(Thread.currentThread().getName()+"拿到锁");
                   Lock.wait();
               }
           }catch (InterruptedException e){
               System.out.println("阻塞时被中断了");
           }
           System.out.println("哇,我结束了!");
       });
       t1.start();
       Thread.sleep(1000);
       synchronized (Lock){
           System.out.println(Thread.currentThread().getName()+"拿到锁");
           t1.interrupt();
       }
    }


}


