package com.kakarot.plcenter.service.impl;

import com.kakarot.plcenter.dao.UserDao;
import com.kakarot.plcenter.entity.User;
import com.kakarot.plcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jinzj on 2017/2/15.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public User getOne(Long id) {
        return userDAO.selectByPrimaryKey(id);
    }
}
