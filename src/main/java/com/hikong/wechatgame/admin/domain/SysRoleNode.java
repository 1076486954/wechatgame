package com.hikong.wechatgame.admin.domain;

/**
 * @Author:zcl
 * @Description:权限角色中间表
 * @Date: 2018/3/23 9:48
 * @Modified By:
 */
public class SysRoleNode {
    private Long role_id;
    private Long node_id;
    private int level;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getNode_id() {
        return node_id;
    }

    public void setNode_id(Long node_id) {
        this.node_id = node_id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
