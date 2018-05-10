package com.kakarot.plcenter;

import com.kakarot.plcenter.config.CoreConfig;
import com.kakarot.plcenter.config.MvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//import com.kakarot.plcenter.config.ShiroConfig;

/**
 * Created by jinzj on 2017/2/4.
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{
                CoreConfig.class,
                MvcConfig.class,
//                DatasourceConfig.class,
//                JobConfig2.class,
//                DubboConfig.class,
//                TaskConfig.class
//                JobConfig.class
//                ShiroConfig.class
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

//    @Override
//    protected Filter[] getServletFilters() {
//        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//        encodingFilter.setEncoding("UTF-8");
//        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("shiroFilter");
//        return new Filter[]{encodingFilter, delegatingFilterProxy};
//        return new Filter[]{};
//    }
}
