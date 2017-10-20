package com.kakarot.plcenter.demo;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.UUID;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class JsonTest {

    @Test
    public void jsonTest() throws Exception {
        Demo demo = new Demo();
        demo.setName(UUID.randomUUID().toString());
        demo.setIds(new Long[2]);
        Map<?,?> map = JSON.parseObject(JSON.toJSONString(demo), Map.class);
        System.out.println(map);
    }
}
