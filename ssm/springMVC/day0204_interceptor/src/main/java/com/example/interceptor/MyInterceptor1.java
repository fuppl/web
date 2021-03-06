package com.example.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 预处理，controller方法执行前
     * return true; 表示放行，执行下一个拦截器或Controller方法
     * return false;不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle。。前1111");
        return true;
    }
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("preHandle...前");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
//        return false;
//    }

    /**
     * 后处理方法,controller方法执行后，success.jsp执行前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);

        System.out.println("postHandle。。后1111");
    }

    /**
     * success.jsp执行后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion。。最后1111");
    }
}
