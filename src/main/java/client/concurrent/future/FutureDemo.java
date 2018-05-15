package client.concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 普通的future例子
 * @author wsp
 * @date 2018/05/15
 */
public class FutureDemo {

    public static void main(String[] args) throws Exception {
       ExecutorService executorService =  Executors.newFixedThreadPool(1);
       Future<Integer> future =  executorService.submit(()->{
           int result = 0;
           for(int i = 0;i<10;i++){
               result +=i;
           }
           Thread.sleep(2000);
           return result;
       });
       //轮询的方式
       /*while(!future.isDone()){
           ;
       }*/
       //超时阻塞的方式
       System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
    }
}
