package com.ydgk.springmvc;

import com.ydgk.springmvc.exceptions.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;


/**
 * @author kfstart
 * @descrption
 * @create 2020-06-23 9:48
 */
@Controller
public class DispatcherController {

    @RequestMapping("/testSimpleMappingExceptionResolver")
    public String testSimpleMappingExceptionResolver(){
        String str = null;
        str.toString();
        return "success";
    }

    @RequestMapping(value = "/testDefaultHandlerExceptionResolver", method = RequestMethod.POST)
    public String testDefaultHandlerExceptionResolver(){
        return "success";
    }

    @RequestMapping("/testResponseStatusExceptionResolver/{num}")
    public String testResponseStatusExceptionResolver(@PathVariable("num")Integer num){
        if(num == 10){
            throw new MyException();
        }
        return "success";
    }


    /*
    如果受理请求的方法出现了 @ExceptionHandler 注解value值指定的异常或其异常的子类时，会交接这个方法处理
    如果想要在受理请求的方法中获取异常对象，可以在方法的入参中声明一个异常参数
    @ExceptionHandler 修饰的方法可以是多个。如果一个Handler中有多个被@ExceptionHandler修饰的方法会
    使用出现异常匹配较为精确的那个处理异常方法进行异常处理

    如何将异常对象传入到错误页面中? 异常处理的方法不能加入 Map 作为入参。
    使用ModelAndView作为方法的返回值
     */
    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView exceptionHandlerMethod(Exception exception){
        System.out.println(exception.getMessage());
        ModelAndView error = new ModelAndView("error");
        error.addObject("exception",exception);
        return error;
    }

//    @ExceptionHandler(Exception.class)
//    public String exceptionHandlerMethod1(Exception exception){
//        System.out.println(">>"+exception.getMessage());
//        return "error";
//    }

    @RequestMapping("/testExceptionHandlerExceptionResolver/{num}")
    public String testExceptionHandlerExceptionResolver(@PathVariable("num")Integer num){
        int i = 10 / num;
        return "success";
    }

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/test")
    public String test(Locale locale){
        String message = messageSource.getMessage("i18n.title", null, locale);
        System.out.println("message = " + message);
        return "success";
    }

    /*
    文件上传
        MultipartFile 作为上传处理方法的参数可以将前台提交的文件内容信息装换成这个对象，
        我们可以通过这个对象获取上传文件的所有信息
     */
    @ResponseBody
    @RequestMapping("/testCommonsMultipartResovler")
    public String testCommonsMultipartResovler(MultipartFile file,String desc) throws IOException {
        System.out.println(file);
        System.out.println(desc);
        String originalFilename = file.getOriginalFilename();// 获取文件的原始文件名
        System.out.println("originalFilename = " + originalFilename);
        long size = file.getSize();// 获取文件的大小
        System.out.println("size = " + size);
        String name = file.getName();// 表单的names属性
        System.out.println("name = " + name);
        String contentType = file.getContentType(); // 获取内容类型
        System.out.println("contentType = " + contentType);
        InputStream inputStream = file.getInputStream(); // 获取文件对应的输入流
        System.out.println("inputStream = " + inputStream);
        return "Load Success";
    }

}
