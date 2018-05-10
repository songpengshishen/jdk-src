package client.lambda;

/**
 * 任务模板
 */
public class TaskLambdaDemo {

    public static void main(String[] args) {
        Task t1 = (String s)->{
            System.out.println(s);
        };

        t1.execute("aaa");
        t1.template();
    }

}
