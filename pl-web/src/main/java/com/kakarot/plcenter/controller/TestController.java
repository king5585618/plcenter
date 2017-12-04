package com.kakarot.plcenter.controller;

import com.kakarot.plcenter.task.TaskScheduleService;
import com.kakarot.plcenter.task.TestTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by jinzj on 2017/3/8.
 */
@Controller
public class TestController {

//    @Value("${pl.test}")
//    private String value;

    @RequestMapping("/getTest")
    public ModelAndView getTest() {
//        System.out.println(value);
        System.out.println(new Date());
        TaskScheduleService.getInstance().addTask(new TestTask(),300);
        return new ModelAndView("/test").addObject("str","&lt;script&gt;alert(&quot;1&quot;);&lt;/script&gt;");
    }
}
