package com.kakarot.plcenter.dao.impl;

import com.kakarot.plcenter.dao.UserDao;
import com.kakarot.plcenter.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jinzj on 2017/2/13.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public User findOneByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("UserMapper.findOneByUsername", username);
        return user;
    }
}
