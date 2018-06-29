package com.kakarot.plcenter.core;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class JVMTest {

    private Integer i = 0;

    public void a() {
        i++;
        a();
    }

    public static void main(String[] args) {
        JVMTest test = new JVMTest();
        try {
            test.a();
        }catch (Throwable e) {
            System.out.println("i:"+test.i);
            throw e;
        }
    }
}
