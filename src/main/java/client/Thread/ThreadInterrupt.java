package client.Thread;
/**
 * 线程中断示例
 * 为什么需要中断:一个线程在未正常结束之前, 被强制终止是很危险的事情. 因为它可能带来完全预料不到的严重后果. 所以Thread.suspend, Thread.stop等方法都被Deprecated了.
 * 不被推荐使用.但是程序运行中,有时候是有必要让线程死掉,或者让处于休眠的线程提前唤醒的,这时候最好的办法就是使用中断,给线程一个中断信号, 让它自己决定该怎么办.对于正在执行的线程
 * 可以接受中断信号终止运行,对于正在等待某个条件(比如锁)的线程可以接受中断信号异常提前唤醒决定怎么做.
 * 中断:java通过Thread.interrupt方法来中断一个线程,本质就是设置了thread的中断状态值来标识是否是中断
 *     对于非阻塞方法:通过调用interrupted判断,返回true代表被中断了,返回false代表没有中断.并重置中断状态值.
 *     对于阻塞方法:这个线程收到中断信号后, 会抛出InterruptedException并重置中断状态值.
 * @author wsp
 * @since 2017/10/17
 */
public class ThreadInterrupt extends Thread{
    public void run(){
        while(true){
            if(Thread.interrupted()){
                System.out.println("Someone interrupted me.");
            }
            else{
                System.out.println("Going...");
            }
            long now = System.currentTimeMillis();
            while(System.currentTimeMillis()-now<1000){
                // 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
                // 此处用这种方法空转1秒
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadInterrupt();
        t.start();
        Thread.sleep(3000);
        t.interrupt();
    }
}
