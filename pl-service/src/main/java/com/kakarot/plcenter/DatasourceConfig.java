package com.kakarot.plcenter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * Created by jinzj on 2017/2/13.
 */
@Configuration
@Profile("!production")
@ImportResource("classpath:applicationContext.xml")
public class DatasourceConfig {

//    private static final Log log = LogFactory.getLog(DatasourceConfig.class);

//    @Bean
//    public DruidDataSource dataSource() throws Exception {
//        Properties properties = PropertyUtil.getDatasourceProperties("datasource.properties");
//        DruidDataSource source = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//        source.setConnectProperties(properties);
//        return source;
//    }

    /**
     * mybatis文件配置，扫描所有mapper文件
     * @throws Exception
     */
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactoryBean getSqlSessionFactoryBean() throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource());
//        bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//        return bean;
//    }

    /**
     * spring与mybatis整合配置，扫描所有dao
     */
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setBasePackage("com.kakarot.plcenter.dao");
//        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        return configurer;
//    }
//
//    @Bean(name = "transactionManager")
//    public DataSourceTransactionManager dataSourceTransactionManager() throws Exception {
//        DataSourceTransactionManager manager = new DataSourceTransactionManager();
//        manager.setDataSource(dataSource());
//        return manager;
//    }

}
