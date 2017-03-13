package client;

import java.lang.reflect.Field;
import java.util.*;

/**
 *
 */
public class Test<T> {

    public String name;
    public int age;


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<String> a1 = new ArrayList<String>();
        a1.add("a");
        a1.add("b");
        a1.add("c");
        a1.add("d");
        a1.add("e");
        a1.add("f");
        a1.add("g");
        a1.add("h");
        List<String> subList = a1.subList(3,5);
        System.out.println(subList.getClass());
    }


    public static class Test0 extends Test {
        public char sex;
    }

    private static int reverse(int i) {
        String str = Integer.toString(i);
        int length = str.length();
        char[] c = new char[length];
        int chaops = 0;
        length--;
        while (length >= 0) {
            c[chaops++] = str.charAt(length--);
        }
        return Integer.valueOf(new String(c));
    }

}
