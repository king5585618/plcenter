package com.kakarot.plcenter.dao;

import com.kakarot.plcenter.entity.User;

/**
 * Created by jinzj on 2017/2/13.
 */
public interface UserDao {

    //    User findOneByUsername(String username);
    User selectByPrimaryKey(Long id);
}
