package client.stream;

import java.util.stream.Stream;

/**
 * 构建流的例子
 */
public class StreamBuildDemo {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("java","python","c","c++","c#");
        stream.map(String::toUpperCase).forEach((s)->{
            System.out.println(s);
        });
    }

}
