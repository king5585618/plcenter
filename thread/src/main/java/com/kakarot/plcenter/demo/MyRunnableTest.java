package com.kakarot.plcenter.demo;

/**
 * Created by jinzj on 2017/3/6.
 */
public class MyRunnableTest {

    public static void main(String[] args) {
        MyRunnable mt=new MyRunnable();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class MyRunnable implements Runnable {

        private  int ticket = 10;

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票ticket：" + ticket--);
                }
            }
        }
    }
}
