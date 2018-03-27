package com.hikong.wechatgame.admin.controller;

import com.hikong.wechatgame.admin.domain.User;
import com.hikong.wechatgame.admin.service.LearnUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/** 登录
 * Created by tengj on 2017/4/10.
 */
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LearnUserService learnUserService;
    /**
     * @Author: zcl
     * @Description:返回登陆页面
     *  * @param null
     * @Date: 2018/3/25 10:33
     */
    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }
    /**
     * @Author: zcl
     * @Description:登陆方法
     *  * @param null
     * @Date: 2018/3/25 10:33
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,User user){
        Map<String,Object> map =new HashMap<String,Object>();
        Subject subject = SecurityUtils.getSubject();
        String hashAlgorithmName = "MD5";//加密方式
        Object crdentials = user.getPassword();//密码原值
        Object salt = ByteSource.Util.bytes(user.getUsername());//盐值
        int hashIterations = 1024;//加密1024次
        Object result = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        //String password = new SimpleHash("MD5",user.getPassword(),user.getUsername(),2).toHex();
        User user1 = learnUserService.queryLearnUserByUserName(user.getUsername());
        if(subject.isAuthenticated()){
            map.put("result","1");
            //return "index";
        }else {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
            String error = null;
            try {
                subject.login(token);
            } catch (UnknownAccountException e) {
                // TODO: handle exception
                map.put("error","用户名/密码错误");
                //error = "用户名/密码错误";
            }catch (IncorrectCredentialsException e) {
                // TODO: handle exception
                map.put("error","用户名/密码错误");
                //error = "用户名/密码错误";
            }catch (AuthenticationException e) {
                // TODO: handle exception
                map.put("error","其他错误"+e.getMessage());
                //error = "其他错误"+e.getMessage();
            }
            if(subject.isAuthenticated()){
                map.put("result","1");
                //return "index";
            }else {
                map.put("result","0");
                //return "login";
            }
        }
        if(map.get("result").toString().equals("1")){
            return "index";
        }else{
            return "login";
        }

    }
    /**
     * @Author: zcl
     * @Description:无权限提示页面
     * @param null
     * @Date: 2018/3/25 10:34
     */
    @RequestMapping("/403")
    public String noRole(){
        return "403";
    }
}
