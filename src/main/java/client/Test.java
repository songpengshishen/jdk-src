package client;

/**
 *
 */
public class Test {


    public static void main(String[] args) {
        Package[] pk = Package.getPackages();
        for (Package p : pk){
            System.out.println(p);
        }
        Package p1 =  Package.getPackage("client");
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
