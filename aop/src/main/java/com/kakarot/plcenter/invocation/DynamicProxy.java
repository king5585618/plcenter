package com.kakarot.plcenter.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class DynamicProxy implements InvocationHandler {
    private Object target;

    public Object getProxyObject(Object object){
        this.target = object;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start ...");
        Object result = method.invoke(target,args);
        System.out.println("end ...");
        return result;
    }

    public static void main(String[] args) {
        IMath math = (IMath) new DynamicProxy().getProxyObject(new Math());
        int n1 =100;
        int n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}
