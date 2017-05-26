package com.kakarot.plcenter.util;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by jinzj on 2017/4/12.
 */
public class Const {
    public static ApplicationContext Application_context = null; //该值会在web容器启动时由WebAppContextListener初始化

    public static WebApplicationContext Web_Application_context;
}
