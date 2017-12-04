package com.kakarot.plcenter.task;

import java.util.Date;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class TestTask extends AbstractTask {
    @Override
    public void process() {
        System.out.println(new Date());
    }
}
