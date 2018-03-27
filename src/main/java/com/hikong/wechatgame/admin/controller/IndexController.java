package com.hikong.wechatgame.admin.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 主页
 * Created by tengj on 2017/4/10.
 */


@Controller
public class IndexController {

    @RequestMapping("/main")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String main(){
        return "main";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
