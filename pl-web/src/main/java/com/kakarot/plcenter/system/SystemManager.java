package com.kakarot.plcenter.system;

import com.kakarot.plcenter.util.Const;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

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

        if(contextRefreshedEvent.getApplicationContext().getParent()!=null){
            init();
        }
    }

    public void init() throws BeansException {
        Map<String, InitializationExecution> beans;
        if(Const.Application_context!=null){
            beans = Const.Application_context.getBeansOfType(InitializationExecution.class);
            beans.values().forEach(InitializationExecution::run);
        }
        if(Const.Web_Application_context!=null){
            beans = Const.Web_Application_context.getBeansOfType(InitializationExecution.class);
            beans.values().forEach(InitializationExecution::run);
        }
    }
}
