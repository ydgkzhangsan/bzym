package com.ydgk.springmvc.convertors;

import com.ydgk.springmvc.entities.Department;
import com.ydgk.springmvc.entities.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-22 10:19
 */
@Component
public class StringToEmployeeConvertor implements Converter<String,Employee> {
    @Override
    public Employee convert(String s) {
        // 编写转换的逻辑  FF-ff@aliyun.com-0-1004
        if(s != null && !"".equals(s)){
            String[] strs = s.split("-");
            Employee employee = new Employee(null, strs[0], strs[1], Integer.parseInt(strs[2]), new Department(Integer.parseInt(strs[3]), null));
            return employee;
        }
        return null;
    }
}
