package com.ydgk.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-24 9:46
 */
@Controller
public class DispatcherController {

    @RequestMapping("/test")
    public String testMethod(){
        System.out.println("DispatcherController.testMethod");
        return "success";
    }

}
