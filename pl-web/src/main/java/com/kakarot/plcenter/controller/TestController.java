package com.kakarot.plcenter.controller;

import com.alibaba.fastjson.JSON;
import com.kakarot.plcenter.util.IPAdressUtils;
import com.kakarot.plcenter.vo.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jinzj on 2017/3/8.
 */
@Controller
public class TestController {

//    @Value("${pl.test}")
//    private String value;

//    @RequestMapping("/getTest")
//    public ModelAndView getTest() {
////        System.out.println(value);
//        System.out.println(new Date());
//        TaskScheduleService.getInstance().addTask(new TestTask(),300);
//        return new ModelAndView("/test").addObject("str","&lt;script&gt;alert(&quot;1&quot;);&lt;/script&gt;");
//    }

    @RequestMapping("/postIndex")
    public String postIndex(){
        System.out.println(IPAdressUtils.getIp());
        return "/post";
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String testPost(@RequestBody TestVO vo){
        System.out.println(JSON.toJSONString(vo));
        return "SUCCESS";
    }
}
