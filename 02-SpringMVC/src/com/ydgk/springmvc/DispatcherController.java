package com.ydgk.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-18 14:13
 */
@Controller
public class DispatcherController {

    /*
    可以使用普通的java类作为方法的入参。会将请求参数中和Java类属性名称相同的参数赋值为对应的属性
     */
    @RequestMapping("/testPojo")
    public String testPojo(Person person){
        System.out.println("person = " + person);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String jid){
        System.out.println("jid = " + jid);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String lg,
                                    @RequestHeader("Cookie") String cookie){
        System.out.println("lg = " + lg);
        System.out.println("cookie = " + cookie);
        return "success";
    }

    /*
    @RequestParam 注解
        用于获取请求参数
        属性：
          required： 用于指定该参数是否是必须的，默认为 true 不传入便报 400 异常
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "age", required = false ,defaultValue = "0")int age){
        System.out.println("age = " + age);
        return "success";
    }

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
