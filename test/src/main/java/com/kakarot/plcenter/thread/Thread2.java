package com.kakarot.plcenter.thread;

import java.util.Date;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Thread2 {

    public static void main(String[] args) throws InterruptedException {
//        for(;;){
//            Thread.sleep(1000L);
//            System.out.println(new Date());
//        }

//        Object obj = new Object();
        for(;;){
//            obj.wait(3000L);
//            wait();
            System.out.println(new Date());
        }
    }
}
