package client.date;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * localDate例子
 * @author wsp
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017,5,15);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonthValue());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.toString());
        LocalDate currentDate = LocalDate.now();
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime.toString());
    }

}
