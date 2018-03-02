package com.kakarot.plcenter.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Client {

    public static void main(String[] args) {
        TestService testService = new TestServiceImpl();
        InvocationHandler handler = new RealTest(testService);
        TestService service = (TestService) Proxy.newProxyInstance(handler.getClass().getClassLoader(),testService.getClass().getInterfaces(),handler);
        service.send();
    }
}
