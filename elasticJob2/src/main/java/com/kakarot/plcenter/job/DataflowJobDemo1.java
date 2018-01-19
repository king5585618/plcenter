package com.kakarot.plcenter.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Component
@SimpleScheduled(cron = "0 0/1 * * * ?", description = "DataflowJobDemo1")
public class DataflowJobDemo1 implements DataflowJob<DataflowDemo> {

    @Override
    public List<DataflowDemo> fetchData(ShardingContext shardingContext) {
        List<DataflowDemo> list = new ArrayList<>();
        list.add(new DataflowDemo("1"));
        list.add(new DataflowDemo("2"));
//        return list;
        return null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<DataflowDemo> data) {
        System.out.println(data.toString());
    }
}
