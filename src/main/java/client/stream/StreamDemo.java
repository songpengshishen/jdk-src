package client.stream;

import client.lambda.Apple;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 流是java 1.8所引入的一种对集合数据进行遍历和计算的元素序列,流是从一个支持数据处理的数据源中生成的一个元素序列.
 * 流可以通过一种高级的类似于Sql语句声明式的方式计算集合的数据,并且可以透明的使用并行计算能力.(你不需要再去操心多线程和锁的使用了)
 * @author wsp
 * @date 2018/05/08
 */
public class StreamDemo {

    public static void main(String[] args) {
        distinctDemo();
    }



    public static void simpleDemo(){
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

    /**
     * 去除重复
     */
    public static void distinctDemo(){
        List<Integer> numbers = Arrays.asList(1,2,3,1,3,2);
        numbers.stream().distinct().forEach((Integer i) ->{
            System.out.println(i);
        });
    }

    public static void limitDemo(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        numbers.stream().limit(3).forEach((i)->{
            System.out.println(i);
        });
    }

    /**
     * 匹配元素
     */
    public static void matchDemo(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        boolean flag1 = numbers.stream().anyMatch((i)->{return i<3;});
        System.out.println(flag1);


        boolean flag2 = numbers.stream().allMatch((i)->{return i<3;});
        System.out.println(flag2);
    }

    /**
     * 查找元素
     */
    public static void findDemo(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> result = numbers.stream().filter((i)->{return i<1;}).findAny();
        System.out.println(result.isPresent());
    }

    /**
     * 类似sql中的聚合函数sum max等
     */
    public static void reduceDemo(){
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> sum = numbers.parallelStream().reduce(Integer::max);
        System.out.println(sum);
    }

}
