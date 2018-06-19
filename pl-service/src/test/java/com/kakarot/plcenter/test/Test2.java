package com.kakarot.plcenter.test;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class Test2 {

    @org.junit.Test
    public void test() throws Exception {
        String path = "http://image.jumore.test/jfs1/000/13/5B/rBIBPVsd1yOAVhfoAAD6s0wxMls963.pdf";
        System.out.println(path.substring(path.indexOf("/")));
    }
}
