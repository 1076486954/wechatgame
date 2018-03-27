package com.hikong.wechatgame.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:zcl
 * @Description:拼图游戏控制器
 * @Date: 2018/3/27 14:45
 * @Modified By:
 */
@Controller
@RequestMapping("/pintu")
public class PinTuController {

    @RequestMapping("pintu_1")
    public String pintu_1(){
        return "game/pintu_1";
    }
}
