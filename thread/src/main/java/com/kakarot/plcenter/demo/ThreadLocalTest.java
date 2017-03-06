package com.kakarot.plcenter.demo;

/**
 * Created by jinzj on 2017/3/3.
 */
public class ThreadLocalTest {

    private static ThreadLocal seqNum = new ThreadLocal<Integer>() {
        public Integer initialValue() {
            return 0;
        }
    };

    //②获取下一个序列值
    public int getNextNum() {
        Integer num = (Integer) seqNum.get();
        seqNum.set(num + 1);
        return num + 1;
    }

    public static void main(String[] args) {
        ThreadLocalTest sn = new ThreadLocalTest();
        //③ 3个线程共享sn，各自产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread {
        private ThreadLocalTest sn;

        public TestClient(ThreadLocalTest sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {//④每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() +
                        "] sn[" + sn.getNextNum() + "]");
            }
        }
    }
}
