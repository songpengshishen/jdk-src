package client.lambda;
public class LambdaTest {

    public static void main(String[] args) {
       LambdaTest lambdaTest = new LambdaTest();
       lambdaTest.process(() -> System.out.println("hello lambda"));
    }

    public void process(Runnable r){
        r.run();
    }
}
