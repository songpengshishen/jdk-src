package client.optional;

import java.util.Optional;

/**
 * jdk1.8 optional 示例
 * @author wsp
 */
public class OptionalDemo {

    public static void main(String[] args) {
        /*Optional<String> aNull =  Optional.of(null);*/
        Optional.ofNullable(null);
        Optional<String> e1 = Optional.empty();
        Optional<String> e2 = Optional.empty();
        System.out.println(e1 == e2);
        System.out.println(e1.isPresent());
        System.out.println(e2.orElse("hello optional"));
    }
}
