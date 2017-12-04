package com.kakarot.plcenter.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Test1 {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(5);
        Thread thread = new Thread(new Consumer1(queue));
        Thread thread1 = new Thread(new Producer1(queue));
        thread.start();
        thread1.start();
    }
}
