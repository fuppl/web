package com.example.controller;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回值为字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString...");

        //模拟从数据库中查询到用户
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(20);

        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回值为void
     * @param
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid...");
        //编写请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //编写重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        //设置编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接进行响应
        response.getWriter().print("hello 哈喽");

    }

    /**
     * 返回值为ModelAndView
     * @param
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testString...");
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询到用户
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(20);

        //把user对象存储到mv对象中，底层也会把user对象存储到request中
        mv.addObject("user", user);

        //跳转到那个页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字的方式进行转发或重定向
     * @param
     * @return
     */
    @RequestMapping("/testFrowardOrRedirect")
    public String testFrowardOrRedirect(){
        System.out.println("testFrowardOrRedirect...");
        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求和响应
     * @param
     * @return
     */
    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body) {
        System.out.println("testAjax...");
        System.out.println(body);
    }


}
