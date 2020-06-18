package com.ydkg.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-18 10:13
 */
@RequestMapping("/abc")
@Controller
public class HelloWorldController {

    /*
    @RequestMapping 是用来映射请求的，如果浏览器发送的请求和RequestMapping中的值一致，就使用该注解
    标注的方法处理这个请求

    @RequestMapping 注解可以修饰方法也可以修饰类, 先需要找到类之后才能找到类中受理请求的方法。

        value属性
            根据请求的URL确定请求受理的方法
        method属性
            根据请求的方式确定受理请求的方法

        以下两种方式作为了解
        params属性
            根据请求的参数确定请求受理的方法
            params属性是一个字符串类型的数组，支持一些简单的表达式 !  =  !=
        headers 属性
            根据请求头中的参数确定请求受理的方法
            headers 属性是一个字符串类型的数组，支持一些简单的表达式 !  =  !=

        请求路径支持通配符映射
            使用一个通配符路径映射请求到受理请求的方法
            ? 表示匹配一个任意字符
            * 表示匹配一层路径中的任意多个字符
            ** 表示匹配多层路径中的任意字符
     */
    @RequestMapping("/**/testAnt?")
    public String testAnt(){
        return "success";
    }

    @RequestMapping(value = "/testHeaders",headers = {"Accept-Language=zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7"})
    public String testHeaders(){
        return "success";
    }

    @RequestMapping(value = "/testParam", params = {"name!=zhangsan","age"})
    public String testParam(){
        return "success";
    }

    @RequestMapping(value = "/hello", method = {RequestMethod.POST})
    public String hello(){
        System.out.println("HelloWorld!");
        return "success";
    }

}
