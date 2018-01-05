package client.Thread;
/**
 * 线程中断示例
 * 为什么需要中断:一个线程在未正常结束之前, 被强制终止是很危险的事情. 因为它可能带来完全预料不到的严重后果. 所以Thread.suspend, Thread.stop等方法都被Deprecated了.
 * 不被推荐使用.但是程序运行中,有时候是有必要让线程死掉,或者让处于休眠的线程提前唤醒的,这时候最好的办法就是使用中断,给线程一个中断信号, 让它自己决定该怎么办.对于正在执行的线程
 * 可以接受中断信号终止运行,对于正在等待某个条件(比如锁)的线程可以接受中断信号异常提前唤醒决定怎么做.
 * 中断:java通过Thread.interrupt方法(是一个实例方法)来中断一个线程.其实就是设置了线程的中断状态为true,不过如果线程被
 *     Object.wait, Thread.join和Thread.sleep以及线程的本地方法之一阻塞,则会收到一个中断信号提前退出阻塞状态并抛出InterruptedException异常,同时清空中断状态.
 * 如何判断线程是否中断 : 有2种方法
 *                    1 实例方法 : Thread.currentThread().isInterrupted()
 *                    2 静态方法 : Thread.interrupted()
 *                    以上俩个方法返回ture代表线程被中断,返回false代表没有被中断,区别在于实例方法不会情况中断状态,而静态方法会清空中断状态.
 * @author wsp
 * @since 2017/10/17
 */
public class ThreadInterrupt extends Thread{
    public void run(){
        while(true){
          try {
              if(Thread.currentThread().isInterrupted()){
                  System.out.println("Someone interrupted me.");
              }
              else{
                  System.out.println("Going...");
              }
              Thread.sleep(3000);
          }catch (Exception e){
              System.out.println("被中断了,中断状态:"+Thread.interrupted());
          }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadInterrupt();
        t.start();
        Thread.sleep(50);
        t.interrupt();
    }
}
