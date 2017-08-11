package client;


import java.lang.reflect.Field;
import java.util.*;

/**
 *
 */
public class Test<T> {


    public static void main(String[] args) throws Exception {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING    = -1 << COUNT_BITS;
        int SHUTDOWN   =  0 << COUNT_BITS;
        int STOP       =  1 << COUNT_BITS;
        int TIDYING    =  2 << COUNT_BITS;
        int TERMINATED  =  3 << COUNT_BITS;
    }


}


