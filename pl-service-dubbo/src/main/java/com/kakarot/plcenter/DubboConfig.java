package com.kakarot.plcenter;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author jinzj
 * @since v4.0.0
 */
@Configuration
@ImportResource(value = "classpath:spring-service-dubbo.xml")
public class DubboConfig {
}
