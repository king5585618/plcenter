package com.kakarot.plcenter.core;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class FinalizeGCTest {

    public static FinalizeGCTest test = null;

    public void alive() {
        System.out.println("yes, alive");
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize executed");
        FinalizeGCTest.test = this;
    }

    public static void main(String[] args) throws InterruptedException {
        test = new FinalizeGCTest();
        test = null;
        System.gc();
        Thread.sleep(500L);
        if(null==test){
            System.out.println("dead");
        }else {
            test.alive();
        }

        test = null;
        System.gc();
        Thread.sleep(500L);
        if(null==test){
            System.out.println("dead");
        }else {
            test.alive();
        }
    }
}
