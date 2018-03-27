package com.hikong.wechatgame.tools.basedbpackage;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * @Author:zcl
 * @Description:
 * @Date: 2018/3/24 14:31
 * @Modified By:
 */
public class AbstractBaseDao extends SqlSessionDaoSupport {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
