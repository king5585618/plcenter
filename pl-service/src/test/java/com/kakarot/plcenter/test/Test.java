package com.kakarot.plcenter.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {

    @org.junit.Test
    public void test() {
//        JSONObject object = new JSONObject();
//        object.put("1",1);
//        System.out.println(object);
        BigDecimal a = new BigDecimal("600.11");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = a.multiply(b).setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal d = new BigDecimal("540.101").setScale(2, RoundingMode.HALF_EVEN);
        System.out.println(c);
        System.out.println(c.compareTo(d));
    }
}
