package com.kakarot.plcenter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author jinzj
 * @since v4.0.1
 */
@Configuration
@ComponentScan(value = "com.kakarot.plcenter.jedis")
@ImportResource(value = {"classpath:jedis.xml"})
public class JedisConfig {
}
