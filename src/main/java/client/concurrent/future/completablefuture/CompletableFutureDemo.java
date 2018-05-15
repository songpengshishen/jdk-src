package client.concurrent.future.completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * 完全的future
 */
public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception{
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("异步执行!");
            return  new Integer(1);
        });
        completableFuture = completableFuture.whenComplete((i,e)->{
            System.out.println(i);
            System.out.println(e);
        });
        System.out.println(completableFuture.get());
    }
}
