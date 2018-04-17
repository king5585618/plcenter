package com.kakarot.plcenter.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class DateTest {

    private static SimpleDateFormat DATE_TIME_FORMAT=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static void main(String[] args) {
        Date date = new Date();
        String time=DATE_TIME_FORMAT.format(date);
        System.out.println(time);
    }

    public static String filterEmoji(String source,String slipStr) {
        return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
    }
}
