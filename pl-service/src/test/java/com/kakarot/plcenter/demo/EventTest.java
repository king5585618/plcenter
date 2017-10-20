package com.kakarot.plcenter.demo;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class EventTest {

    @com.google.common.eventbus.Subscribe
    public void sub(String msg){
        System.out.println(msg+"111111111111");
    }
}
