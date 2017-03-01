package com.kakarot.plcenter.controller;

import com.kakarot.plcenter.entity.User;
import com.kakarot.plcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jinzj on 2017/3/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/findOne")
    public void findOne(Long id) {
        User user = userService.getOne(id);
        System.out.println(user);
    }
}
