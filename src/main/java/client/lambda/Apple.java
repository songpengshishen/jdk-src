package client.lambda;

/**
 * 一个用来排序的苹果对象
 */
public class Apple {

    private Integer weight;


    public Apple(Integer weight){
        this.weight = weight;
    }


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
