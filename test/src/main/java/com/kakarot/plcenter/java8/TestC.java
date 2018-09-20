package com.kakarot.plcenter.java8;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class TestC implements TestA,TestB {

    public static void main(String[] args) {
        new TestC().hello();
    }
}
