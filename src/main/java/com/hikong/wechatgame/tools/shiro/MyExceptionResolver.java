package com.hikong.wechatgame.tools.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:zcl
 * @Description:捕捉没有权限引发的异常,跳转错误页面
 * @Date: 2018/3/23 16:27
 * @Modified By:
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        if(e instanceof UnauthorizedException){
            ModelAndView mv = new ModelAndView("/403");
            return  mv;
        }
        e.printStackTrace();
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", e.toString().replaceAll("\n", "<br/>"));
        return mv;
    }
}
