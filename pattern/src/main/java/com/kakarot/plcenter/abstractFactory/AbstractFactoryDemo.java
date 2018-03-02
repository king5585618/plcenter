package com.kakarot.plcenter.abstractFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jinzj
 * @since v4.0.1
 *
 * 简单工厂
 */
public class AbstractFactoryDemo {

    private static Map<String, DemoInterface> map = new ConcurrentHashMap<>(16);

    private static void builder() {
        if(map.isEmpty()){
            map.put(DemoInterface1.class.getSimpleName(),new DemoInterface1());
            map.put(DemoInterface2.class.getSimpleName(), new DemoInterface2());
        }
    }

    public static DemoInterface getBean(String name) {
        if(map.isEmpty()){
            builder();
        }
        return map.get(name);
    }

    public static void main(String[] args) {
        DemoInterface demoInterface = AbstractFactoryDemo.getBean(DemoInterface1.class.getSimpleName());
        System.out.println(demoInterface);
    }
}
