package client.function.interfaces;

/**
 * Created by wangsongpeng on 2017/3/28.
 */
public class client {
    public static void main(String[] args) {
        MyFunctionInterface functionInterface = ()-> System.out.println("hello world");
        functionInterface.sayHello();
    }
}
