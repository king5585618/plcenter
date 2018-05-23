package com.kakarot.plcenter.demo2;

import com.alibaba.fastjson.JSONObject;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        DemoA demoA = new DemoA();
        DemoB demoB = new DemoB();
        demoB.setName("222222");
        demoA.setId(2L);
        demoA.setDemo(demoB);

        DemoA1 demoA1 = new DemoA1();
//        BeanUtils.copyProperties(demoA,demoA1);
        String str = JSONObject.toJSONString(demoA);
        DemoA1 aaa =JSONObject.toJavaObject(JSONObject.parseObject(str), DemoA1.class);
        System.out.println(demoA1);
    }
}
