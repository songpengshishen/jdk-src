package client;

import java.lang.reflect.Field;

/**
 *
 */
public class Test<T> {

    public String name;
    public int age;


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Field[] fields = Test0.class.getFields();
        int i = 0;
        while (fields.length>i){
            System.out.println(fields[i++]);
        }


    }



    public static class Test0 extends Test{
          public char sex;
    }

    private static int reverse(int i){
          String str =  Integer.toString(i);
          int length = str.length();
          char[] c = new char[length];
          int chaops = 0;
          length--;
          while(length>=0){
               c[chaops++] = str.charAt(length--);
          }
          return Integer.valueOf(new String(c));
    }

}
