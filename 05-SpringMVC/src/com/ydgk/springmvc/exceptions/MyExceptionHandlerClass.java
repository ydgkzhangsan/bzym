package com.ydgk.springmvc.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-23 16:39
 */
/*
想要定义一个类是异常处理类，需要使用@ControllerAdvice注解修饰这个类，
被这个注解修饰的类会被SpringMVC扫描到。
 */
@ControllerAdvice
public class MyExceptionHandlerClass {

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView exceptionHandlerMethod(Exception exception){
        System.out.println(exception.getMessage());
        ModelAndView error = new ModelAndView("error");
        error.addObject("exception",exception);
        return error;
    }

}
