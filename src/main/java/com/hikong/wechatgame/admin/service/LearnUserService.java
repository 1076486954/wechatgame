package com.hikong.wechatgame.admin.service;


import com.hikong.wechatgame.admin.dao.LearnUserDao;
import com.hikong.wechatgame.admin.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnUserService {

    @Autowired
    LearnUserDao learnUserDao;

    public User queryLearnUserById(Long id) {
        return this.learnUserDao.queryLearnUserById(id);
    }


    public User queryLearnUserByUserName(String username) {
        return this.learnUserDao.queryLearnUserByUserName(username);
    }
}
