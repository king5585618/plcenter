package com.kakarot.plcenter.queue;

import java.util.concurrent.BlockingQueue;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class Consumer1 implements Runnable{

    private BlockingQueue blockingQueue;

    public Consumer1(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

            try {
                for(int i=0;i<10;i++) {
                    System.out.println(blockingQueue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
