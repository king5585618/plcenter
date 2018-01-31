package com.kakarot.plcenter.controller;

import com.kakarot.plcenter.RemoteService;
import com.kakarot.plcenter.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jinzj
 * @since v4.0.0
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
public class DubboController {

    @Autowired
    private RemoteService remoteService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getRandom")
    public void getRandom() {
//        TestService testService = remoteService.getRemoteService(TestService.class,"1.0.0");
        System.out.println(testService.getRandomNum());
    }
}
