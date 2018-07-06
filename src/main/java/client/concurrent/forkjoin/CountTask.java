package client.concurrent.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * fork-join并行计算框架 计算需求:1+2+3....这样的任务
 *
 * @author wsp
 * @date 2018/05/10
 */
public class CountTask extends RecursiveTask<Integer> {

    /**
     * 划分任务的阀值数
     */
    private static final int THRESHOLD = 2;

    /**
     * 起始值
     */
    private int start;

    /**
     * 结束值
     */
    private int end;


    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * 并行计算方法
     *
     * @return
     */
    @Override
    protected Integer compute() {
        printCurrentInfo();
        int sum = 0;
        //判断任务是否足够小
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            //如果小于阈值，就进行运算
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //如果大于阈值，就再进行任务拆分
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到执行结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }



    private void printCurrentInfo(){
          Thread thread =  Thread.currentThread();
          CountTask task = this;
          System.out.println("执行当前任务的线程 : " + thread);
          System.out.println("当前任务的信息 : " + task);
          System.out.print("\n\n\n");
    }

    @Override
    public String toString() {
        return "CountTask{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1, 6);
        //执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
