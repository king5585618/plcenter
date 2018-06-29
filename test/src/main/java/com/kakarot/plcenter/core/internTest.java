package com.kakarot.plcenter.core;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class internTest {

    public static void main(String[] args) {
        String s = new StringBuilder().append("ja").append("va").toString();
        System.out.println(s.intern()==s);
    }
}
