package com.kakarot.plcenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.kakarot.plcenter.util.PropertyUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Properties;

/**
 * Created by jinzj on 2017/2/8.
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

}
