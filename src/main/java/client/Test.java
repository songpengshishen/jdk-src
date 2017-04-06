package client;


import java.lang.reflect.Field;
import java.util.*;

/**
 *
 */
public class Test<T> {


    public static void main(String[] args) throws Exception {
        List<String> testArr = new ArrayList<String>();
        testArr.add("a");
        testArr.add("b");
        testArr.add("c");
        ListIterator<String> listIterator =  testArr.listIterator(3);
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }


}


