package client.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * 循环屏障同步工具类
 * @author wsp
 * @since 2018/1/3
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) throws Exception{
        CyclicBarrier cb = new CyclicBarrier(3);
        Thread wsp1  =  new CyclicBarrierThread(cb,"wsp-1");
        Thread wsp2  =  new CyclicBarrierThread(cb,"wsp-2");
        wsp1.start();wsp2.start();
        Thread.sleep(3000);
        cb.await();
        System.out.println("线程:" + Thread.currentThread().getName()+"执行整体任务一完毕!");

        /*************CyclicBarrier可以循环的使用,下面是第二次使用**************/

        Thread wsp3  =  new CyclicBarrierThread(cb,"wsp-3");
        Thread wsp4  =  new CyclicBarrierThread(cb,"wsp-4");
        wsp3.start();wsp4.start();
        Thread.sleep(3000);
        cb.await();
        System.out.println("线程:" + Thread.currentThread().getName()+"执行整体任务二完毕!");
    }

    static class CyclicBarrierThread extends Thread{

        private CyclicBarrier cyclicBarrier;

        public CyclicBarrierThread(CyclicBarrier cyclicBarrier,String tName){
               super(tName);
               this.cyclicBarrier = cyclicBarrier;
        }


        @Override
        public void run() {
            System.out.println("线程:" + Thread.currentThread().getName()+"开始执行任务一");
            try {
                Thread.sleep(1000);//模拟干活*/
                cyclicBarrier.await();//等待其余线程都达到到屏障状态在执行余下任务
            }catch (Exception e){
                 System.out.println("线程:" + Thread.currentThread().getName()+"被中断了!");
                 e.printStackTrace();
            }
            System.out.println("线程:" + Thread.currentThread().getName()+"开始执行任务二");
        }
    }
}
