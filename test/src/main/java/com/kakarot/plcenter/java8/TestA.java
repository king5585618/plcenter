package com.kakarot.plcenter.java8;

/**
 * @author jinzj
 * @since v4.0.1
 */
public interface TestA {

    default void hello() {
        System.out.println("A");
    }
}
