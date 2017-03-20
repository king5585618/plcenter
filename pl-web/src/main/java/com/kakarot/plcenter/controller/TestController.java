package com.kakarot.plcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jinzj on 2017/3/8.
 */
@Controller
public class TestController {

    @RequestMapping("/getTest")
    public ModelAndView getTest() {
        return new ModelAndView("/test").addObject("str","&lt;script&gt;alert(&quot;1&quot;);&lt;/script&gt;");
    }
}
