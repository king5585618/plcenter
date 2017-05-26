package com.kakarot.plcenter.job;

import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.dangdang.ddframe.job.plugin.job.type.simple.AbstractSimpleElasticJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author jinzj
 * @since v1.0.0
 */
@Component
public class TestJob extends AbstractSimpleElasticJob {

    @Override
    public void process(JobExecutionMultipleShardingContext shardingContext) {
        System.out.println(new Date());
    }
}
