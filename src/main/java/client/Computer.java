package client;

/**
 *  java 1.8新增的接口扩展方法,使用关键字 default向接口中加入非抽象方法.
 * @author wangsongpeng
 */
public interface Computer {

    int add();

    default int count(){
       return add();
    }
}
