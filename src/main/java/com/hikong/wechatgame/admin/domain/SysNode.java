package com.hikong.wechatgame.admin.domain;

/**
 * @Author:zcl
 * @Description:权限点类
 * @Date: 2018/3/23 9:45
 * @Modified By:
 */
public class SysNode {
    private Long id;
    private String url;
    private String nodename;
    private String nodetitle;
    private int isused;
    private String remark;
    private int pid;
    private int level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNodename() {
        return nodename;
    }

    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public String getNodetitle() {
        return nodetitle;
    }

    public void setNodetitle(String nodetitle) {
        this.nodetitle = nodetitle;
    }

    public int getIsused() {
        return isused;
    }

    public void setIsused(int isused) {
        this.isused = isused;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
