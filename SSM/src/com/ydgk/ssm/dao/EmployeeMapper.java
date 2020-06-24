package com.ydgk.ssm.dao;

import com.ydgk.ssm.entities.Employee;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-24 11:50
 */
public interface EmployeeMapper {

    @Select("select * from employee")
    List<Employee> getAll();

}
