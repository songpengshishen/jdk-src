package client.stream;

import client.lambda.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 流是java 1.8所引入的一种对集合数据进行遍历和计算的元素序列,流是从一个支持数据处理的数据源中生成的一个元素序列.
 * 流可以通过一种高级的类似于Sql语句声明式的方式计算集合的数据,并且可以透明的使用并行计算能力.(你不需要再去操心多线程和锁的使用了)
 * @author wsp
 * @date 2018/05/08
 */
public class StreamDemo {

    public static void main(String[] args) {
        //使用JDK1.8的流方式实现集合中数据的筛选,排序..
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple(10));
        apples.add(new Apple(11));
        apples.add(new Apple(12));
        apples.add(new Apple(5));
        apples.add(new Apple(4));
        apples.add(new Apple(2));
        //筛选出重量低于10的苹果并排序
        List<Apple> appleList = apples.parallelStream().
                                filter((Apple a1) -> {return a1.getWeight() < 10;}).
                                sorted(Comparator.comparing(Apple::getWeight)).
                                collect(Collectors.toList());
        System.out.println(appleList);
    }
}
