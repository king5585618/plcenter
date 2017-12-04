package com.kakarot.plcenter.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Producer1 implements Runnable {

    private BlockingQueue blockingQueue;

    public Producer1(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){
                blockingQueue.put(i);
                Thread. sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
