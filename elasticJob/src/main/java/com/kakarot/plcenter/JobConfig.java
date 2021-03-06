package com.kakarot.plcenter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jinzj
 * @since v1.0.0
 */
@Configuration
@ComponentScan(value = "com.kakarot.plcenter.job")
//@ImportResource(value = {"classpath:job-service.xml"})
public class JobConfig {
}
