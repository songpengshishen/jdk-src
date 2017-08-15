package client;


import java.lang.reflect.Field;
import java.util.*;

/**
 *
 */
public class Test<T> {


    public static void main(String[] args) throws Exception {
        int COUNT_BITS = Integer.SIZE - 3;
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println(CAPACITY);
    }


}


