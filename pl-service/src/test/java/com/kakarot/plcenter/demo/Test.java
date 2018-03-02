package com.kakarot.plcenter.demo;

import com.alibaba.fastjson.JSON;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
//        BigDecimal i = new BigDecimal("10.00");
//        System.out.println(i.toString());
//        System.out.println(i.toPlainString());
//        Map map = new HashMap();
//        map.put("id","1");
//        map.put("user_name","aaa");
        String str = "{\"id\":1,\"user_name\":\"aaa\"}";
        Demo2 demo = JSON.parseObject(str, Demo2.class);
        System.out.println(demo.getUserName());
    }
}
