package com.kakarot.plcenter.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class AtomicDemo{


    private static final AtomicInteger TEST_INT = new AtomicInteger();



    /**
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000; i++) {
            service.execute(()-> System.out.println(TEST_INT.getAndIncrement()));
        }
        service.shutdown();
        System.out.println("最终结果：" + TEST_INT);
    }
}