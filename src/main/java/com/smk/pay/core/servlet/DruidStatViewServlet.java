package com.smk.pay.core.servlet;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Project plouto
 * Created by chuanzhi.macz
 * Date 2016/10/20 17:23
 */
@WebServlet(urlPatterns = "/druid/*",
        initParams = {
                @WebInitParam(name = "loginUsername", value = "chuanzhi.macz"),// 用户名
                @WebInitParam(name = "loginPassword", value = "chuanzhi.macz"),// 密码
                @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet extends StatViewServlet {
}
