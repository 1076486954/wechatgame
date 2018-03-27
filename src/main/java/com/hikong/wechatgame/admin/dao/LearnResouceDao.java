package com.hikong.wechatgame.admin.dao;

import com.hikong.wechatgame.admin.domain.LearnResouce;
import com.hikong.wechatgame.tools.basedbpackage.BaseDao;
import com.hikong.wechatgame.tools.basedbpackage.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author:zcl
 * @Description:
 * @Date: 2018/3/25 9:48
 * @Modified By:
 */
@Repository("learnResouceDao")
public class LearnResouceDao extends BaseDaoImpl<LearnResouce> implements BaseDao<LearnResouce> {
    public int add(LearnResouce learnResouce){
        return getSqlSession().insert(this.getClassName()+".add",learnResouce);
    }
    public int update(LearnResouce learnResouce){
        return getSqlSession().update(this.getClassName()+"update",learnResouce);
    }
    public int deleteByIds(String[] ids){
        return getSqlSession().delete(this.getClassName()+".deleteByIds",ids);
    }
    public LearnResouce queryLearnResouceById(Long id){
        return getSqlSession().selectOne(this.getClassName()+".queryLearnResouceById",id);
    }
    public List<LearnResouce> queryLearnResouceList(Map<String, Object> params){
        return getSqlSession().selectList(this.getClassName()+".queryLearnResouceList",params);
    }
}
