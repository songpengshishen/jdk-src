package client.demo;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试类
 * @author wsp
 * @since 2017/07/18
 */
public class TestClass extends TestAbstractClass implements TestInterface{


    @Override
    public void test1() {

    }

    @Override
    public void test2() {

    }


    public static void main(String[] args) {
        String a = "aa";
        String b = new String("aa");
        String[] c = new String[2];
        Set<String> set = new HashSet<String>();
        System.out.println(set.add(a));
        System.out.println(set.add(b));
        set.toArray(c);

    }
}
