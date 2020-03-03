package com.example.controller;

import com.example.domain.Account;
import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password){
        System.out.println("执行了。。。");
        System.out.println(username);
        System.out.println(password);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 原生servlet API
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了。。");
        System.out.println("请求:"+request);
        HttpSession session = request.getSession();
        System.out.println("session:" + session);
        ServletContext sc = session.getServletContext();
        System.out.println("ServletContext:" + sc);
        System.out.println("response:" + response);
        return "success";
    }
}
