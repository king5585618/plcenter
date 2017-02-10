package com.kakarot.plcenter.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by jinzj on 2017/2/8.
 */
public class PropertyUtil {

    public static Properties getDatasourceProperties(String path) throws IOException {
        Resource res = new ClassPathResource(path);
        InputStream input = res.getInputStream();
        Properties properties = new Properties();
        properties.load(input);
        return properties;
    }
}
