package com.hikong.wechatgame.admin.domain;
/**
 * @Author:zcl
 * @Description:角色类
 * @Date: 2018/3/23 9:45
 * @Modified By:
 */
public class SysRole {
    private Long id;
    private String name;
    private String pincode;
    private String pid;
    private int isused;
    private String memo;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getIsused() {
        return isused;
    }

    public void setIsused(int isused) {
        this.isused = isused;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
