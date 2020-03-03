package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    /**
     * RequestMapping测试
     * @return
     */
    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("RequestMapping测试");
        return "success";
    }
}
