package com.ydgk.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-19 9:55
 */
@Controller
/*
    @SessionAttributes 注解可以将模型中的数据暂存到 HttpSession 中
        value 属性是根据模型中数据的键名称暂存的
        types 属性模型中数据的类型暂存
 */
//@SessionAttributes(value = {"user"}, types = {String.class})
public class DispatcherController {

    @RequestMapping("/testBeanNameViewResolver")
    public String testBeanNameViewResolver(){
        return "myView";
    }


    /*
    @ModelAttribute 注解可以修饰方法
        修饰方法时，会在任何目标受理请求方法调用之前调用
        在 ModelAttribute注 解修饰的方法中可以向模型中存入数据，
        存入的数据可能会作为前台数据存入的模板

        修饰入参

    注意： SpringMVC 在调用受理请求方法之前会在模型中取出参数类型首字母小写的数据，作为方法的入参。

    总结ModelAttribute注解作用流程：
        1、从数据库中取出 User , 将 User 存入模型对象中
        2、SpringMVC 一定在某个时刻将模型中的数据取出，作为接收前台表单中传入的值。
        3、SpringMVC将模型中的 user 作为方法的入参
     */
    @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) Integer id,
                        Map map){
        System.out.println("DispatcherController.getUser");
        if(id != null){
            //从数据库中取出对应的对象    并将对象存入模型中
            map.put("abc",new User(1,"zhangsan","zhangsan@qq.com",18));
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("abc") User user){
        System.out.println("修改User为："+ user);
        return "success";
    }

    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Map map){
        map.put("user",new User(1,"zhangsan","zhangsan@qq.com",18));
        map.put("school", "ydgk");
        return "success";
    }

}
