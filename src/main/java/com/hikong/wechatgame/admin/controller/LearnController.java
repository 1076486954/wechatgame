package com.hikong.wechatgame.admin.controller;

import com.hikong.wechatgame.admin.domain.LearnResouce;
import com.hikong.wechatgame.admin.service.LearnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 教程页面
 * Created by tengj on 2017/3/13.
 */
@Controller
@RequestMapping("/learn")
public class LearnController {
    @Autowired
    private LearnService learnService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("")
    public String learn(HttpServletRequest request){
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("page",1);
        paraMap.put("rows",5);
        List<LearnResouce> learnResouceList = learnService.queryLearnResouceList(paraMap);
        System.out.println(learnResouceList.size());
        request.setAttribute("learnResouceList",learnResouceList);
        return "learn-resource";
    }

    /*@RequestMapping(value = "/queryLeanList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public void queryLearnList(HttpServletRequest request , HttpServletResponse response){
        String page = request.getParameter("page"); // 取得当前页数,注意这是jqgrid自身的参数
        String rows = request.getParameter("rows"); // 取得每页显示行数，,注意这是jqgrid自身的参数
        String author = request.getParameter("author");
        String title = request.getParameter("title");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("page", page);
        params.put("rows", rows);
        params.put("author", author);
        params.put("title", title);
        List<LearnResouce> learnList=learnService.queryLearnResouceList(params);
        PageInfo<LearnResouce> pageInfo =new PageInfo<LearnResouce>(learnList);
        JSONObject jo=new JSONObject();
        jo.put("rows", learnList);
        jo.put("total", pageInfo.getPages());//总页数
        jo.put("records",pageInfo.getTotal());//查询出的总记录数
        ServletUtil.createSuccessResponse(200, jo, response);
    }*/
}