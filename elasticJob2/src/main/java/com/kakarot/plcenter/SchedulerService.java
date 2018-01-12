package com.kakarot.plcenter;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.kakarot.plcenter.job.SimpleScheduled;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author jinzj
 * @since v4.0.0
 */
public class SchedulerService implements BeanPostProcessor,InitializingBean {

    @Value("${elastic.job.zookeeper.url}")
    private String zookeeperUrl;

    @Value("${enableJob}")
    private boolean enableJob;

    private static final String namespace = "elastic-demo";

    private CoordinatorRegistryCenter registryCenter;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof SimpleJob){
            if(!enableJob){
                return bean;
            }
            SimpleJob job = (SimpleJob) bean;
            SimpleScheduled annotation = job.getClass().getAnnotation(SimpleScheduled.class);
            if (annotation == null || null==annotation.cron())
                throw new NullPointerException("注解配置不正确");
            JobCoreConfiguration simpleCoreConfig = JobCoreConfiguration.newBuilder(beanName, annotation.cron(), 1)
                    .description(annotation.description()).build();
            SimpleJobConfiguration simpleJobConfig = new SimpleJobConfiguration(simpleCoreConfig, job.getClass().getCanonicalName());
            LiteJobConfiguration simpleJobRootConfig = LiteJobConfiguration.newBuilder(simpleJobConfig).build();
            SpringJobScheduler springJobScheduler = new SpringJobScheduler(job,registryCenter,simpleJobRootConfig);
            springJobScheduler.init();
        }
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(!enableJob){
            return;
        }
        CoordinatorRegistryCenter regCenter = new ZookeeperRegistryCenter(
                new ZookeeperConfiguration(zookeeperUrl, namespace));
        registryCenter = regCenter;
        registryCenter.init();
    }
}
