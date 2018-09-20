package com.kakarot.plcenter.java8;

/**
 * @author jinzj
 * @since v4.0.1
 */
public interface TestB extends TestA {

    default void hello() {
        System.out.println("B");
    }
}
