package com.hikong.wechatgame.tools.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.PostConstruct;

/**
 * @Author:zcl
 * @Description:配置shiro标签
 * @Date: 2018/3/23 17:08
 * @Modified By:
 */
@Component
public class ShiroTagsFreeMarkerCfg{
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
    @PostConstruct
    public void setSharedVariable() throws TemplateModelException{
        freeMarkerConfigurer.getConfiguration().setSharedVariable("shiro",new ShiroTags());
    }
}
