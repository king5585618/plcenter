package com.kakarot.plcenter.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Component
@SimpleScheduled(cron = "0/10 * * * * ?", description = "SimpleJobDemo1")
public class SimpleJobDemo1 implements SimpleJob {


    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println("1");
    }
}
