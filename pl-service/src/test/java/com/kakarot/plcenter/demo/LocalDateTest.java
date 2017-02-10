package com.kakarot.plcenter.demo;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jinzj on 2017/2/8.
 */
public class LocalDateTest {

    @Test
    public void getWeekDay() throws Exception {
        LocalDate date = LocalDate.now();
        date = date.minusYears(100);
        System.out.println(date.getDayOfWeek());
    }

    @Test
    public void plusMouths() throws Exception {
        Period period = Period.ofYears(100);
        LocalDate date = LocalDate.now();
        LocalDate future = date.plus(period);
        assertThat(future.getYear()-date.getYear()).isEqualTo(100);
    }
}
