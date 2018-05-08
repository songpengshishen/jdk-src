package client.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        new LambdaTest().methonRefFunctionSort();
    }


    /**
     * 策略模式实现排序,实现起来繁琐啰嗦，创建一些类实现一个只有一个方法的接口,但是可能只实例化一次
     */
    public void strategySort(){
        List<Apple> apples = initAppleList();
        apples.sort(new AppleComparator());
        System.out.println(apples);
    }

    /**
     * 匿名实现排序比上面的方法策略模式实现要简化很多
     */
    public void anonymousSort(){
        List<Apple> apples = initAppleList();
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(apples);
    }

    /**
     * lambda表达式实现排序
     */
    public void lambdaSort(){
        List<Apple> apples = initAppleList();
        apples.sort((Apple o1,Apple o2) ->{return o1.getWeight().compareTo(o2.getWeight());});
        System.out.println(apples);
    }


    /**
     * lambda表达式简化版实现排序,但是不推荐这么使用,可读性不好.
     */
    public void lambdaSimpleSort(){
        List<Apple> apples = initAppleList();
        apples.sort((o1,o2) ->{return o1.getWeight().compareTo(o2.getWeight());});
        System.out.println(apples);
    }


    /**
     * 使用方法引用以及Comparator#comparing的Funtion结合实现排序
     * 方法引用可以简化lambda表达式，转发它们的参数
     * Comparator#comparing这个方法入参为Function函数式接口用来提取比较的键值.
     *
     * @return
     */
    public void methonRefFunctionSort(){
        List<Apple> apples = initAppleList();
        apples.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(apples);
    }


    private List<Apple> initAppleList(){
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple(5));
        apples.add(new Apple(4));
        apples.add(new Apple(3));
        return apples;
    }

    static class AppleComparator implements Comparator<Apple>{
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    }
}
