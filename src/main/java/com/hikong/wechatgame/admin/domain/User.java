package com.hikong.wechatgame.admin.domain;

/**
 * Created by tengj on 2017/3/29.
 */
public class User {
    private Long id;
    private String username;
    private String password;
    private int role_id;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
