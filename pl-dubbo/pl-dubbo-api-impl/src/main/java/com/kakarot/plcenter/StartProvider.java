package com.kakarot.plcenter;

import com.alibaba.dubbo.container.Main;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class StartProvider {

    public static void main(String[] args){
        System.setProperty("dubbo.spring.config", "/dubbo-service-api.xml");
        Main.main(args);
    }
}
