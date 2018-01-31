package com.kakarot.plcenter.api.impl;

import com.kakarot.plcenter.api.TestService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Service
public class TestServiceImpl extends BaseServiceImpl implements TestService {

    private static final Random random = new Random();

    @Override
    public Integer getRandomNum() {
        return random.nextInt(100);
    }
}
