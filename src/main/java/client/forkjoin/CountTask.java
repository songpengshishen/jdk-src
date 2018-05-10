package client.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * fork-join并行计算框架 计算需求:1+2+3....这样的任务
 * @author wsp
 * @date 2018/05/10
 */
public class CountTask extends RecursiveTask {

    /**
     * 计算阀值
     */
    private static final int threshold = 2;

    @Override
    protected Object compute() {
        return null;
    }
}
