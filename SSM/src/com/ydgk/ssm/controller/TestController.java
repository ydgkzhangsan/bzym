package com.ydgk.ssm.controller;

import com.ydgk.ssm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-24 11:32
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String testMethod(){
        System.out.println("TestController.testMethod");
        testService.testMethod();
        return "success";
    }

}
