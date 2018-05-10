package client.stream;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 并行流例子
 */
public class ParallelStreamDemo {

    public static void main(String[] args) {

        long n = 100000000000l;
        parallel(n);
    }



    public static void serial(long count){
        long time = System.currentTimeMillis();
        long result = 0;
        for(long i = 1 ;i<=count;i++){
            result+=i;
        }
        System.out.println("结果值 : " + result + "\t" +"耗时 : " + (System.currentTimeMillis() - time));
    }


    public static void parallel(long count){
        long time = System.currentTimeMillis();
        long result  = LongStream.rangeClosed(1,count).parallel().sum();
        System.out.println("结果值 : " + result + "\t" +"耗时 : " + (System.currentTimeMillis() - time));
    }
}
