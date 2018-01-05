package client.concurrent;
import java.util.concurrent.Semaphore;

/**
 * 信号量同步工具类
 * @author wsp
 * @since 2018/01/04
 */
public class SemaphoreDemo {

   private static final int THREAD_COUNT = 30;

   private static  Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for(int i = 0; i < THREAD_COUNT ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /*尝试获得许可证*/
                        if(semaphore.tryAcquire()){
                            System.out.println("Thread Name :" +Thread.currentThread().getName() + " Save Data Ing...!");
                        }else{
                            System.out.println("Thread Name :" +Thread.currentThread().getName() + " Can't Execute!");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            },"wsp-"+i).start();
        }
    }

}
