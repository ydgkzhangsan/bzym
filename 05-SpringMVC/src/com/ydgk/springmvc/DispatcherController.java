package com.ydgk.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;


/**
 * @author kfstart
 * @descrption
 * @create 2020-06-23 9:48
 */
@Controller
public class DispatcherController {

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
