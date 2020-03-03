package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;


/**
 * 常用注解
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = "msg")// todo 相当于把msg=美美存到session中，原来只是在request中
public class AnnoController  {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了。。。");
        System.out.println(username);
        return "success";
    }

    /**
     * PathVariable注解
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取到请求体的内容
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了。。。");
        System.out.println(body);
        return "success";
    }

    /**
     * 获取请求头的值
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("执行了。。。");
        System.out.println(header);
        return "success";
    }

    /**
     * 获取Cookie的值
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue){
        System.out.println("执行了。。。");
        System.out.println(cookieValue);
        return "success";
    }

    /**
     *  todo ModelAttribute
     *      ModelAttribute注解
     *      1. 出现在方法上：表示当前方法会在控制器方法执行前线执行。
     *      2. 出现在参数上：获取指定的数据给参数赋值。
     * @return
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("testModelAttribute执行了。。。");
        System.out.println(user);
        return "success";
    }

//    /**
//     * 该方法会先执行
//     */
//    @ModelAttribute
//    public User showUser(String uname){
//        System.out.println("showUser方法执行了...");
//        //通过用户名数据库查询（模拟）
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(20);
//        user.setDate(new Date());
//        return user;
//    }

    /**
     * 该方法会先执行
     */
    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        System.out.println("showUser方法执行了...");
        //通过用户名数据库查询（模拟）
        User user = new User();
        user.setUname(uname);
        user.setAge(20);
        user.setDate(new Date());
        map.put("abc", user);
    }

    /**
     * testSessionAttributes
     * @return
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了。。。");
        //底层会存储到request对象中
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @return
     */
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了。。。");
        //底层会存储到request对象中
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus status){
        System.out.println("deleteSessionAttributes。。。");
        //关闭session，则数据清空
        status.setComplete();
        return "success";
    }

}
