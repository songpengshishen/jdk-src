package client.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻主题
 */
public class NewsSubject implements Subject{

    /**
     * 观察者
     */
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers(String msg) {
        observers.forEach((Observer o)->{o.notify(msg);});
    }



    /************观察者内部类*************/

    static class Cctv5Observer implements Observer{
        @Override
        public void notify(String tweet) {
            System.out.println("cctv5播出 : " + tweet);
        }
    }

    static class Cctv6Observer implements Observer{
        @Override
        public void notify(String tweet) {
            System.out.println("cctv6播出 : " + tweet);
        }
    }


    public static void main(String[] args) {
        NewsSubject newsSubject = new NewsSubject();
        //通过普通的观察者模式编码
        Cctv5Observer c5 = new Cctv5Observer();
        Cctv6Observer c6 = new Cctv6Observer();
        /*newsSubject.registerObserver(c5);
        newsSubject.registerObserver(c6);
        newsSubject.notifyObservers("发钱啦!");*/
        //通过lambda模式改造观察者模式等设计模式，可以改变设计模式中死板的创建实现类的弊端
        newsSubject.registerObserver((String msg)->{
            System.out.println("cctv6播出 : " + msg);
        });
        newsSubject.registerObserver((String msg)->{
            System.out.println("cctv5播出 : " + msg);
        });
        newsSubject.notifyObservers("发钱啦!");


    }
}
