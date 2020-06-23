package com.ydgk.springmvc.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-23 14:38
 * 自定义拦截器：
 *      1、定义一个类实现 HandlerInterceptor接口，并实现其中的方法
 *      2、需要配置拦截器
 */
@Component
public class MyFirstInterceptor implements HandlerInterceptor {

    /*
    preHandler方法执行的时机：
        在目标受理请求方法执行之前被调用。

        关于返回值：
            如果不希望preHandler方法执行之后再执行其他拦截器或目标方法，则可以直接返回false
            如果希望 preHandler 方法执行之后，继续执行拦截器或目标方法，则返回true

      作用： 权限、登录、数据源的获取
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("MyFirstInterceptor.preHandle");
        return true;
    }

    /*
    执行时机： postHandler方法时在目标受理请求方法执行之后，渲染视图之前执行的。

        可以修改目标受理请求方法返回的视图
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyFirstInterceptor.postHandle");
    }

    /*
        执行时机： afterCompletion 方法是在渲染视图完成之后执行。

        作用： 可以用来关闭资源，回收资源
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("MyFirstInterceptor.afterCompletion");
    }

}
