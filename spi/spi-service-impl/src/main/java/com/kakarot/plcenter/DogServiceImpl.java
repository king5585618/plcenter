package com.kakarot.plcenter;

/**
 * @author jinzj
 * @since v4.0.1
 */
public class DogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("黑色dog。。。汪汪叫，不睡觉...");
    }
}
