package client.lambda;

/**
 * 函数式接口
 * @author wsp
 * @date 2018/05/10
 */
@FunctionalInterface
public interface Task {

    void execute(String s);

    default void template(){
        System.out.println("默认模板方法!");
    }


}
