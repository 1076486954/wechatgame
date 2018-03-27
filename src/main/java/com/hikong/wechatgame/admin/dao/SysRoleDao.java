package com.hikong.wechatgame.admin.dao;

import com.hikong.wechatgame.admin.domain.SysNode;
import com.hikong.wechatgame.admin.domain.SysRole;
import com.hikong.wechatgame.tools.basedbpackage.BaseDao;
import com.hikong.wechatgame.tools.basedbpackage.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * @Author:zcl
 * @Description:
 * @Date: 2018/3/25 9:31
 * @Modified By:
 */
@Repository("sysRoleDao")
public class SysRoleDao extends BaseDaoImpl<SysRole> implements BaseDao<SysRole>{
    /**
     * @Author: zcl
     * @Description:根据角色ID获取角色信息
     * @Param: roleId
     * @Date: 2018/3/23 9:51
     */
    public SysRole getRoleByRoleId(int roleId){
        return getSqlSession().selectOne(this.getClassName()+".getRoleByRoleId",roleId);
    }
    /**
     * @Author: zcl
     * @Description:根据角色ID获取权限列表
     * @Param: roleId
     * @Date: 2018/3/23 10:02
     */
    public List<SysNode> getNodesByRoleId(Long roleId){
        return getSqlSession().selectList(this.getClassName()+".getNodesByRoleId",roleId);
    }
    /**
     * @Author: zcl
     * @Description:获取用户所有角色的名称
     *  * @param null
     * @Date: 2018/3/23 10:39
     */
    public List<String> getRolesNamesByUserId(Long userId){
        return getSqlSession().selectList(this.getClassName()+".getRolesNamesByUserId",userId);
    }
    /**
     * @Author: zcl
     * @Description:获取用户所有角色的信息
     *  * @param null
     * @Date: 2018/3/23 10:51
     */
    public List<SysRole> getRolesByUserId(Long userId){
        return getSqlSession().selectList(this.getClassName()+".getRolesByUserId",userId);
    }
    /**
     * @Author: zcl
     * @Description:根据角色ID获取角色权限Url
     *  * @param null
     * @Date: 2018/3/23 11:06
     */
    public Collection<String> getNodeNameslByRoleId(Long roleId){
        return getSqlSession().selectList(this.getClassName()+".getNodeNameslByRoleId",roleId);
    }
}
