package com.kakarot.plcenter.system;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.WebApplicationContext;

import com.kakarot.plcenter.util.Const;

/**
 * Created by jinzj on 2017/4/12.
 */
public class SystemManager implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(contextRefreshedEvent.getApplicationContext().getParent()==null){
            Const.Application_context = contextRefreshedEvent.getApplicationContext();
            //JVMHook.start();
        }else{
            Const.Application_context = contextRefreshedEvent.getApplicationContext().getParent();
            Const.Web_Application_context = (WebApplicationContext) contextRefreshedEvent.getApplicationContext();
        }
    }
}
