package com.kakarot.plcenter.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Component
public class Test {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
//        System.out.println(new Date());
    }
}
