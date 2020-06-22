package com.ydgk.springmvc.controller;

import com.ydgk.springmvc.dao.DepartmentDao;
import com.ydgk.springmvc.dao.EmployeeDao;
import com.ydgk.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-20 9:48
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(value = "/emps", method = RequestMethod.GET)
    public String list(Map map){
        // 获取所有的员工信息，并将员工信息存入模型对象中
        map.put("emps",employeeDao.getAll());
        return "list";
    }

    @RequestMapping(value = "/emp" ,method = RequestMethod.GET)
    public String toInput(Map map){
        // 获取所有的部门信息，存入模型中
        map.put("depts",departmentDao.getDepartments());
        // 向模型中存入一个空的Employee
        map.put("employee", new Employee());
        return "input";
    }

    /*
    获取校验结果：
        在需要校验的入参后加入一个BindingResult或Error类型的参数，获取校验结果。
        注意： 该参数必须和校验对象挨着。
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String save(@Valid Employee employee, BindingResult bindingResult,Map map) throws ServletException, IOException {

        /*
         BindingResult 对象的方法：
            hasErrors() 是否校验或转换出错
         */
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError error : fieldErrors){
                System.out.println("Employee的<"+error.getField()+">属性出现错误。" +
                        "错误消息为："+ error.getDefaultMessage());
            }
            // 获取所有的部门信息，存入模型中
            map.put("depts",departmentDao.getDepartments());
            //request.getRequestDispatcher("/WEB-INF/pages/input.jsp").forward(request,response);
            return "input";
        }

        System.out.println(employee);
        // 保存员工信息
        employeeDao.save(employee);
        // 将请求重定向到list页面
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String toEdit(@PathVariable("id")Integer id,Map map){
        // 根据Id获取员工信息，将员工信息存入到模型中
        map.put("employee",employeeDao.get(id));
        // 获取所有的部门信息，存入模型中
        map.put("depts",departmentDao.getDepartments());
        return "input";
    }

    @ModelAttribute
    public void getEmployee(@RequestParam(value = "id", required = false) Integer id,
                            Map map){
        if(id != null){
            //如果请求参数中带了ID 说明是一个修改操作
            // 根据id查询数据库，将ID对应的员工信息保存到模型中。
            map.put("employee",employeeDao.get(id));
        }
    }

    @RequestMapping(value = "/emp" , method = RequestMethod.PUT)
    public String edit(Employee employee){

        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /*
    因为数据的绑定，数据的校验及格式化都是通过webDataBinder对象进行控制的。
    而 @InitBinder 注解修饰方法可以用于控制 webDataBinder 的工作流程
       比如： 控制那些参数不被绑定到方法的入参
     */
//    @InitBinder
//    public void testInitBinder(WebDataBinder webDataBinder){
//        // 表示不去绑定lastName属性
//        webDataBinder.setDisallowedFields("lastName");
//    }

}
