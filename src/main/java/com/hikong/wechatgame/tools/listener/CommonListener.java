package com.hikong.wechatgame.tools.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * @Author:zcl
 * @Description:配置网络路径
 * @Date: 2018/3/21 14:08
 * @Modified By:
 */
@WebListener
public class CommonListener implements ServletContextListener {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context=sce.getServletContext();
        String contextPath=context.getContextPath();
        context.setAttribute("webroot", contextPath);
        logger.info("++++++++++++++++++CommonListener+++++++++++++++++++++");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
