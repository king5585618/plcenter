package com.kakarot.plcenter.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jinzj on 2017/2/9.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView doLogin(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        ModelAndView view = new ModelAndView();
        try {
            SecurityUtils.getSubject().login(token);
            return view;
        } catch (Exception ex) {
            return view;
        }
    }
}
