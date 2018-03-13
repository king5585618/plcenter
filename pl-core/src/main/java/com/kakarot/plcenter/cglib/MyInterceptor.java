package com.kakarot.plcenter.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before:"+method);
        Object object=methodProxy.invokeSuper(o, objects);
        System.out.println("After:"+method);
        return object;
    }

    public static Object createProxy(Class superClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(superClass);
        enhancer.setCallback(new MyInterceptor());
        return enhancer.create();
    }

    public static void main(String[] args) {
        Test test = (Test) MyInterceptor.createProxy(Test.class);
        test.test1();

    }
}
