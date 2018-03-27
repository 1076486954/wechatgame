package com.hikong.wechatgame.admin.service;

import com.hikong.wechatgame.admin.dao.SysRoleDao;
import com.hikong.wechatgame.admin.domain.SysNode;
import com.hikong.wechatgame.admin.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author:zcl
 * @Description:
 * @Date: 2018/3/23 10:04
 * @Modified By:
 */
@Service
public class SysRoleService {
    @Autowired private SysRoleDao sysRoleDao;
    /**
     * @Author: zcl
     * @Description:根据角色ID获取角色信息
     *  * @param null
     * @Date: 2018/3/23 10:05
     */
    public SysRole getRoleByRoleId(int roleId) {
        return sysRoleDao.getRoleByRoleId(roleId);
    }
    /**
     * @Author: zcl
     * @Description:根据角色ID获取权限列表
     *  * @param null
     * @Date: 2018/3/23 10:05
     */
    public List<SysNode> getNodesByRoleId(Long roleId) {
        return sysRoleDao.getNodesByRoleId(roleId);
    }
    /**
     * @Author: zcl
     * @Description:获取用户所有角色的名称
     *  * @param null
     * @Date: 2018/3/23 10:39
     */
    public List<String> getRolesNamesByUserId(Long userId) {
        return sysRoleDao.getRolesNamesByUserId(userId);
    }
    /**
     * @Author: zcl
     * @Description:获取用户所有角色的信息
     *  * @param null
     * @Date: 2018/3/23 10:51
     */
    public List<SysRole> getRolesByUserId(Long userId) {
        return sysRoleDao.getRolesByUserId(userId);
    }
    /**
     * @Author: zcl
     * @Description:根据角色ID获取角色权限Url
     *  * @param null
     * @Date: 2018/3/23 11:06
     */
    public Collection<String> getNodeNameslByRoleId(Long roleId) {
        return sysRoleDao.getNodeNameslByRoleId(roleId);
    }
}
