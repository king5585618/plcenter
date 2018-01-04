package com.kakarot.plcenter.listener;

import com.kakarot.plcenter.system.InitializationExecution;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Component
public class MessageListener extends InitializationExecution {

    @Override
    protected void run() {
        System.out.println(new Date());
    }
}
