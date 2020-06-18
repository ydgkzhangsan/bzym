package com.ydgk.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-18 14:13
 */
@Controller
public class DispatcherController {

    @RequestMapping(value = "/testRest", method = RequestMethod.DELETE)
    public String testDelete(){
        System.out.println("DELETE请求受理了");
        return "success";
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.PUT)
    public String testPut(){
        System.out.println("put请求受理了");
        return "success";
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testPost(){
        System.out.println("post请求受理了");
        return "success";
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.GET)
    public String testGet(){
        System.out.println("get请求受理了");
        return "success";
    }

    /*
    重要：
    @PathVariable 的使用
        如果需要映射路径中的参数，
        首先需要使用占位符将参数取名, 例如 {占位名}
        其次需要在目标受理请求的入参中使用@PathVariable注解将参数绑定给方法入参
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id){
        System.out.println("从路径中获取的参数为:" + id);
        return "success";
    }


    @RequestMapping("/test")
    public String test(){
        return "success";
    }

}
