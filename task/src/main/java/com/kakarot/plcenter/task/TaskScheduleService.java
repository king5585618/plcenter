package com.kakarot.plcenter.task;

import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class TaskScheduleService {
    private static TaskScheduleService scheduleService;
    private static Object object = new Object();

    private ScheduledExecutorService scheduledExecutorService;
    private Vector<LinkedList<AbstractTask>> vector;
    private final static int SHOLT_SIZE = 60; //每秒一次刚好一个分钟
    private int currentIndex = 0;

    public TaskScheduleService() {
        vector = new Vector<>();
        for(int i=0;i<SHOLT_SIZE;i++){
            vector.add(new LinkedList<>());
        }
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
    }

    public void next(){
        LinkedList<AbstractTask> linkedList = vector.get(currentIndex);
        synchronized (object){
            if(!CollectionUtils.isEmpty(linkedList)){
                Iterator<AbstractTask> iterator = linkedList.iterator();
                while (iterator.hasNext()){
                    AbstractTask next = iterator.next();
                    int num = next.getNum();
                    if(num == 0){
                        scheduledExecutorService.execute(next);
                        iterator.remove();
                    }
                    else{
                        next.setNum(num - 1);
                    }
                }
            }
            currentIndex++;
            if(currentIndex == SHOLT_SIZE){
                currentIndex = 0;
            }
        }
    }

    public void addTask(AbstractTask task, int delay){
        if(delay < 1){
            delay = 1; //最少为一秒，避免当前秒没办法读取这个任务
        }
        int num = (delay - (delay % SHOLT_SIZE)) / SHOLT_SIZE;
        int index = (currentIndex + delay) % SHOLT_SIZE;
        task.setIndex(index);
        task.setNum(num);
        LinkedList<AbstractTask> list = vector.get(index);
        synchronized(object){
            if(list == null){
                list = new LinkedList<>();
            }
            list.add(task);
        }
    }

    public static TaskScheduleService getInstance() {
        if(scheduleService==null){
            synchronized (object){
                if(null==scheduleService){
                    scheduleService = new TaskScheduleService();
                }
            }
        }
        return scheduleService;
    }
}
