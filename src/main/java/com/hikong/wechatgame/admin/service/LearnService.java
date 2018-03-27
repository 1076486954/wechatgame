package com.hikong.wechatgame.admin.service;


import com.github.pagehelper.PageHelper;
import com.hikong.wechatgame.admin.dao.LearnResouceDao;
import com.hikong.wechatgame.admin.domain.LearnResouce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by tengj on 2017/4/7.
 */
@Service
public class LearnService {

    @Autowired
    LearnResouceDao learnResouceDao;

    public int add(LearnResouce learnResouce) {
        return this.learnResouceDao.add(learnResouce);
    }


    public int update(LearnResouce learnResouce) {
        return this.learnResouceDao.update(learnResouce);
    }


    public int deleteByIds(String[] ids) {
        return this.learnResouceDao.deleteByIds(ids);
    }


    public LearnResouce queryLearnResouceById(Long id) {
        return this.learnResouceDao.queryLearnResouceById(id);
    }


    public List<LearnResouce> queryLearnResouceList(Map<String,Object> params) {
        PageHelper.startPage(Integer.parseInt(params.get("page").toString()), Integer.parseInt(params.get("rows").toString()));
        return this.learnResouceDao.queryLearnResouceList(params);
    }
}
