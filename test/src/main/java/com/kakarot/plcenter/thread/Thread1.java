package com.kakarot.plcenter.thread;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Thread1 extends Thread {

    public Thread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(;;){

        }
    }

    public static void main(String[] args) {
        Thread1 thread = new Thread1("heihei");
        thread.start();
    }
}
