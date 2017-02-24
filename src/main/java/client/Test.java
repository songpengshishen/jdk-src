package client;

/**
 *
 */
public class Test {


    public static void main(String[] args) {
        byte b = 0;
        char c = 'a';
        short s = 1;
        int bi = b;
        int ci = c;
        int si = s;
        float bf = bi;
        System.out.println(bi);
        System.out.println(ci);
        System.out.println(si);
        System.out.println(bf);
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
