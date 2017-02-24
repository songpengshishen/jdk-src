package client;

/**
 *
 */
public class Test {


    public static void main(String[] args) {
        System.out.println(-(-128) + 127 + 1);
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
