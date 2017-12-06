package com.kakarot.plcenter.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class NoAtomicDemo {

    public static Integer value = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for(int i=0;i<1000;i++){
            executorService.execute(() -> System.out.println(value++));
        }
        executorService.shutdown();
        System.out.println(NoAtomicDemo.value);
    }
}
