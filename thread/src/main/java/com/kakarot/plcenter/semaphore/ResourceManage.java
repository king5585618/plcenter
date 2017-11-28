package com.kakarot.plcenter.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jinzj
 * @since v1.0.0
 */
public class ResourceManage {
    private final Semaphore semaphore ;
    private boolean resourceArray[];
    private final ReentrantLock lock;

    public ResourceManage() {
        this.semaphore = new Semaphore(10, true);
        this.lock = new ReentrantLock(true);
        this.resourceArray = new boolean[10];
        for(int i=0 ;i<10; i++){
            resourceArray[i] = true;//初始化为资源可用的情况
        }
    }

    public void useResource(int userId){
        try {
            semaphore.acquire();
            int id = getResourceId();
            System.out.println("userId:"+userId+"正在使用资源，资源id:"+id);
            Thread.sleep(100);//do something，相当于于使用资源
            resourceArray[id] = true;//退出这个坑
        } catch (InterruptedException e) {

        }finally {
            semaphore.release();
        }
    }

    private int getResourceId(){
        int id = -1;
        lock.lock();
        try{
            for(int i =0;i<10;i++){
                if(resourceArray[i]==true){
                    resourceArray[i]=false;
                    id = i;
                    break;
                }
            }
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return id;
    }

}
