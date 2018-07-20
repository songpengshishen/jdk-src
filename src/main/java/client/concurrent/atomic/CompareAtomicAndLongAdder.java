package client.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 比较原子类与1.8新增的LongAdder性能
 * @author wsp
 */
public class CompareAtomicAndLongAdder {

    private static AtomicInteger ai = new AtomicInteger(0);

    private static LongAdder longAdder = new LongAdder();

    private static int count = 1000000;

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    public static void main(String[] args)throws Exception {
        long startTime = System.currentTimeMillis();
        atomicIncrement();
        countDownLatch.await();
        System.out.println(" result : " + ai.intValue() + " time : " + (System.currentTimeMillis() - startTime) );
    }


    private static void atomicIncrement(){
        for(int i = 0 ; i < count;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ai.incrementAndGet();
                    countDownLatch.countDown();
                }
            }).start();
        }
    }



    private static void adderIncrement(){
        for(int i = 0 ; i < count;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    longAdder.increment();
                    countDownLatch.countDown();
                }
            }).start();
        }
    }

}
