package client;


import java.lang.reflect.Field;
import java.util.*;

/**
 *
 */
public class Test<T> {


    public static void main(String[] args) throws Exception {
        int i = 0;
        retry:
        for (;;) {
             if(i<5){
                 System.out.println(i++);
                 continue retry;
             }
            break retry;
        }
        System.out.println("over!");
    }


}


