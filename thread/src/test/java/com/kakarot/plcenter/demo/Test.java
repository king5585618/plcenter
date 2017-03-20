package com.kakarot.plcenter.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jinzj on 2017/3/8.
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        String str = "{'username':'1','password':'2'}";
        JSONObject object = JSON.parseObject(str);
        Set<String> set = object.keySet();
        for (String s : set) {

        }
        System.out.println(object);
    }

    @org.junit.Test
    public void list() throws Exception {
        List<String> list = new ArrayList<>();
        Object o = list;
        System.out.println(o instanceof List);

    }

    @org.junit.Test
    public void converter() throws Exception {
        TestModel model = new TestModel();
        BeanWrapper bw = new BeanWrapperImpl(model);
        bw.setPropertyValue("good", "off"); //bw.setPropertyValue("good", "1");//bw.setPropertyValue("good", "true");//bw.setPropertyValue("good", "yes");
        System.out.println(model.isGood());
    }

    @org.junit.Test
    public void shortTest() throws Exception {
        Integer b = null;
        Integer c = 1;
        System.out.println(b != c);
    }

}
