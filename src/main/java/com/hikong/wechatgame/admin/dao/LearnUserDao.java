package com.hikong.wechatgame.admin.dao;

import com.hikong.wechatgame.admin.domain.User;
import com.hikong.wechatgame.tools.basedbpackage.BaseDao;
import com.hikong.wechatgame.tools.basedbpackage.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

/**
 * @Author:zcl
 * @Description:
 * @Date: 2018/3/24 14:38
 * @Modified By:
 */
@Repository("learnUserDao")
public class LearnUserDao extends BaseDaoImpl<User> implements BaseDao<User> {
    public User queryLearnUserById(Long id){
        return getSqlSession().selectOne(this.getClassName()+".queryLearnUserById",id);
    }
    public User queryLearnUserByUserName(String username){
        return getSqlSession().selectOne(this.getClassName()+".queryLearnUserByUserName",username);
    }
}
