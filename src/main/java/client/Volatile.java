package client;

/**
 * Volatile小例子
 * @author wsp
 */
public class Volatile {

     int count = 0;
     boolean flag = false;



    public static void main(String args[])throws InterruptedException{
        Volatile v1 = new Volatile();
        T t1 = new T(v1);
        Thread t = new Thread(t1);
        t.start();
        for(int i = 0;i<10;i++){

        }
        v1.flag = true;
        v1.count = 10;
        t.join();
    }



    static class T implements Runnable{

        private Volatile v;

        public T(Volatile v){
            this.v = v;
        }

        @Override
        public void run() {
              if(v.flag){
                  System.out.println("flag = " + v.flag + "count = " + v.count);
              }else {
                  System.out.println("flag = " + v.flag + "count = " + v.count);
              }
        }
    }
}
