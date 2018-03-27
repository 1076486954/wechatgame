package com.hikong.wechatgame.tools.basedbpackage.impl;

import com.hikong.wechatgame.tools.basedbpackage.AbstractBaseDao;
import com.hikong.wechatgame.tools.basedbpackage.BaseDao;

import java.lang.reflect.ParameterizedType;

/**
 * @Author:zcl
 * @Description:
 * @Date: 2018/3/24 14:32
 * @Modified By:
 */
public class BaseDaoImpl<T> extends AbstractBaseDao implements BaseDao<T> {
    public String getClassName() {
        Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        String classFullName = entityClass.getName();
        return classFullName.substring(classFullName.lastIndexOf(".")+1,classFullName.length()).toLowerCase();
    }
}
