package com.kakarot.plcenter.api.impl;

import com.kakarot.plcenter.api.BaseService;

/**
 * @author jinzj
 * @since v4.0.0
 */
public abstract class BaseServiceImpl implements BaseService {

    public static final String DUBBO_VERSION = "1.0.0";

    @Override
    public String getVersion(){
        return DUBBO_VERSION;
    }

}
