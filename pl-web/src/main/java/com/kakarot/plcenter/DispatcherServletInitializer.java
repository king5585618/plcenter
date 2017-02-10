package com.kakarot.plcenter;

import com.kakarot.plcenter.config.CoreConfig;
import com.kakarot.plcenter.config.DatasourceConfig;
import com.kakarot.plcenter.config.MvcConfig;
import com.kakarot.plcenter.config.ShiroConfig;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by jinzj on 2017/2/4.
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                CoreConfig.class,
                MvcConfig.class,
                DatasourceConfig.class,
                ShiroConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("shiroFilter");
        return new Filter[]{delegatingFilterProxy};
    }
}
