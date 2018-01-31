package com.kakarot.plcenter.api.impl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.kakarot.plcenter.api.BaseService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Component
public class BeanInitService implements BeanPostProcessor, ApplicationContextAware{

    private ApplicationContext applicationContext;

    private ApplicationConfig applicationConfig = null;

    private RegistryConfig registryConfig = null;

    private ProtocolConfig dubboProtocol = null;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(Objects.isNull(this.applicationConfig)){
            this.applicationConfig = applicationContext.getBean(ApplicationConfig.class);
        }

        if(Objects.isNull(registryConfig)) {
            this.registryConfig = applicationContext.getBean(RegistryConfig.class);
        }
        if(Objects.isNull(dubboProtocol)){
            this.dubboProtocol = (ProtocolConfig) applicationContext.getBean("dubbo");
        }

        if(bean instanceof BaseService){
            BaseService baseService = (BaseService) bean;
            exportRemoteService(baseService);
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void exportRemoteService(BaseService baseService) {
        Class baseClass = getInterfaceService(baseService.getClass());
        ServiceConfig<BaseService> service = new ServiceConfig<>();
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig);
        List<ProtocolConfig> protocols = new ArrayList<>();
        protocols.add(dubboProtocol);

        service.setProtocols(protocols);
        service.setInterface(baseClass);
        service.setRef(baseService);
        service.setVersion(baseService.getVersion());

        // 暴露及注册服务
        service.export();

    }

    private Class getInterfaceService(Class cls) {
        Class[] interfaces = cls.getInterfaces();
        Class iface = interfaces[0];
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i].equals(BaseService.class)) {
                continue;
            } else {
                iface = interfaces[i];
                break;
            }
        }
        return iface;
    }
}
