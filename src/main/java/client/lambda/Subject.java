package client.lambda;

/**
 * 观察者模式主题接口
 */
public interface Subject {

    void registerObserver(Observer observer);

    void notifyObservers(String msg);

}
