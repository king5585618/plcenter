package com.kakarot.plcenter.demo;

import org.junit.Test;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class PingziTest {

    @Test
    public void getBottleNum() throws Exception {
        //总共
        int bottleTotal = 5;
        //瓶子
        int bottleNum = 5;
        //瓶盖
        int bottleLid = 5;
        while (bottleNum>=2||bottleLid>=4){
            while (bottleNum>=2){
                bottleNum = bottleNum - 1;
                bottleLid ++;
                bottleTotal++;
            }
            while (bottleLid>=4){
                bottleLid = bottleLid - 3;
                bottleNum++;
                bottleTotal++;
            }
        }
        System.out.println("可以喝"+bottleTotal);
        System.out.println("剩余瓶子"+bottleNum);
        System.out.println("剩余瓶盖"+bottleLid);
    }
}
