package com.kakarot.plcenter.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class Producer implements Runnable {
    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            queue.add("1");
            Thread.sleep(1000);
            queue.add("2");
            Thread.sleep(1000);
            queue.add("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

