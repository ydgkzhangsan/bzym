package com.ydgk.ssm.controller;

import com.ydgk.ssm.entities.Employee;
import com.ydgk.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-24 11:52
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("/getEmpAll")
    public List<Employee> getEmp(){
        return employeeService.getEmpAll();
    }

}
