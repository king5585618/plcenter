package com.kakarot.plcenter;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class RemoteService implements ApplicationContextAware {

    private Object lock = new Object();

    private ApplicationContext applicationContext;

    private ApplicationConfig applicationConfig = null;

    private RegistryConfig registryConfig = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    static class CachedRemoteValue {
        ReferenceConfig refConfig;

        Object remoteService;
    }

    private Map<String, CachedRemoteValue> cacheMap = Collections
            .synchronizedMap(new HashMap<String, CachedRemoteValue>());

    private <T> T getRemoteServiceByCache(Class<T> cls, String key,String version) {
        if (cacheMap.containsKey(key)) {
            Object remoteService = cacheMap.get(key).remoteService;
            return (T) remoteService;
        } else {
            if(Objects.isNull(this.applicationConfig)){
                this.applicationConfig = applicationContext.getBean(ApplicationConfig.class);
            }

            if(Objects.isNull(registryConfig)) {
                this.registryConfig = applicationContext.getBean(RegistryConfig.class);
            }
            ReferenceConfig<T> reference = new ReferenceConfig<>();
            reference.setApplication(applicationConfig);

            reference.setRegistry(registryConfig);
            reference.setInterface(cls);
            reference.setProtocol(DubboProtocol.NAME);
            reference.setVersion(version);
            T remoteService = reference.get();

            // 将生成的结果放入缓存
            CachedRemoteValue value = new CachedRemoteValue();
            value.refConfig = reference;
            value.remoteService = remoteService;
            cacheMap.put(key, value);
            return remoteService;
        }
    }

    public <T> T getRemoteService(Class<T> cls, String version) {
        String name = cls.getName();
        String key = name + "_" + version;
        if (cacheMap.containsKey(key)) {
            Object remoteService = cacheMap.get(key).remoteService;
            return (T) remoteService;
        } else {
            synchronized (lock) {
                return getRemoteServiceByCache(cls, key, version);
            }
        }
    }
}
