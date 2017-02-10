package com.kakarot.plcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jinzj on 2017/2/9.
 */
@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }
}
