package com.hikong.wechatgame.tools.config;

import com.hikong.wechatgame.tools.shiro.MyExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:zcl
 * @Description:创建没有权限后捕获异常Bean
 * @Date: 2018/3/23 16:39
 * @Modified By:
 */
@Configuration
public class MyExceptionResolveConfig {
    @Bean
    public MyExceptionResolver myExceptionResolve(){
        MyExceptionResolver myExceptionResolve = new MyExceptionResolver();
        return myExceptionResolve;
    }
}
