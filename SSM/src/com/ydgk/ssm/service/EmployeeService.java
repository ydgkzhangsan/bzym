package com.ydgk.ssm.service;

import com.ydgk.ssm.dao.EmployeeMapper;
import com.ydgk.ssm.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-24 11:51
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeDao;

    public List<Employee> getEmpAll() {
        return employeeDao.getAll();
    }

}
