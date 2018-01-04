package com.kakarot.plcenter.demo;

import java.math.BigDecimal;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        BigDecimal i = new BigDecimal("10.00");
        System.out.println(i.toString());
        System.out.println(i.toPlainString());
    }
}
