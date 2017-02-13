package com.kakarot.plcenter;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.kakarot.plcenter.util.PropertyUtil;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;

/**
 * Created by jinzj on 2017/2/13.
 */
@Configuration
@Profile("!production")
public class DatasourceConfig {

    @Bean
    public DruidDataSource dataSource() throws Exception {
        Properties properties = PropertyUtil.getDatasourceProperties("datasource.properties");
        DruidDataSource source = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        source.setConnectProperties(properties);
        return source;
    }

    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        return bean;
    }


}
