package com.kakarot.plcenter.demo;

import com.google.common.eventbus.Subscribe;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class EventTest {

    @com.google.common.eventbus.Subscribe
    public void sub(String msg){
        System.out.println(msg+"111111111111");
    }

    @Subscribe
    public void send(Demo2 demo2){
        System.out.println(demo2.getId());
        System.out.println(demo2.getUserName());
    }
}
