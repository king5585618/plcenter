package com.kakarot.plcenter.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class RealTest implements InvocationHandler{

    private Object test;

    public RealTest(Object test) {
        this.test = test;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(test,args);
        System.out.println("after");
        return null;
    }
}
