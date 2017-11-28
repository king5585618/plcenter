package com.kakarot.plcenter.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class UserDemoTest {

    @Test
    public void verifyNotNull() throws Exception {
        UserDemo demo = new UserDemo(1L,"2",null,null);
        String[] str = new String[]{"id","userName","password"};

        for(String name: str){
            String methodName = "get"+ name.substring(0,1).toUpperCase() + name.substring(1);
            Method method = demo.getClass().getMethod(methodName);
            method.setAccessible(true);
            Object value = method.invoke(demo);
            System.out.println(value);
        }

        for(Field f: demo.getClass().getDeclaredFields()){
            f.setAccessible(true);
            System.out.println(f.get(demo));
        }
    }

    @Test
    public void verifyEqual() throws Exception {
        Object o = null;
        UserDemo demo = (UserDemo)o;
        System.out.println(demo);
    }
}
