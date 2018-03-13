package com.kakarot.plcenter.demo;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

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
    }

    @Test
    public void testAysncEventBus2() {
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));
        eventBus.register(new EventTest());
        eventBus.post(100+"  test");
        Demo2 demo2 = new Demo2();
        demo2.setId("111");
        demo2.setUserName("22222");
        eventBus.post(demo2);
    }




}
