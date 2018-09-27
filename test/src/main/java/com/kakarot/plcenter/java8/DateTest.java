package com.kakarot.plcenter.java8;

import java.time.*;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class DateTest {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        LocalTime time1 = LocalTime.now();
        System.out.println(time1);
        Instant instant = Instant.now();
        System.out.println(instant);
        Duration d = Duration.between(time, LocalDateTime.now());
        System.out.println(d);
    }
}
