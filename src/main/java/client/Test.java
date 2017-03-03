package client;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 *
 */
public class Test<T> {

    public String name;
    public int age;


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       List<String> arrayList = new ArrayList<String>();
       arrayList.add("a");
       arrayList.add("b");
       arrayList.add("c");
       arrayList.add("d");
       arrayList.add("e");
       arrayList.add("f");
       ListIterator<String>  strIt =  arrayList.listIterator();

           System.out.println(strIt.next());
           System.out.println(strIt.next());
        System.out.println(strIt.previousIndex());

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
