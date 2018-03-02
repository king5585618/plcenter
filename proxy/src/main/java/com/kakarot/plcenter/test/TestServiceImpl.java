package com.kakarot.plcenter.test;

import java.util.Random;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class TestServiceImpl implements TestService {

    private static final Random RANDOM = new Random();

    @Override
    public void send() {
        System.out.println(RANDOM.nextInt(1000));
    }
}
