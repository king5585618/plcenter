package com.kakarot.plcenter.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author jinzj
 * @since v4.0.0
 */
@org.springframework.stereotype.Component
public class TaskScheduled {

    private TaskScheduleService service = TaskScheduleService.getInstance();

    @Scheduled(cron="*/1 * * * * ?")
    public void execute(){
        service.next();
    }
}
