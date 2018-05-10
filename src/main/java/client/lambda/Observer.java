package client.lambda;

/**
 * 观察者接口
 * 函数式接口
 */
@FunctionalInterface
public interface Observer {

    void notify(String tweet);

}
