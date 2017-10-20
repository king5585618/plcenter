package com.kakarot.plcenter.demo;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.Executors;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class EventBusTest {

    @Test
    public void testEventBus() {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventTest());//注册事件
        eventBus.post("ssdf");// 触发事件处理
    }

    @Test
    public void testAysncEventBus() {
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));
        eventBus.register(new EventTest());
        for(int i=0;i<1000;i++){
            eventBus.post(i+"  test");
        }
        HashMap
    }




}
