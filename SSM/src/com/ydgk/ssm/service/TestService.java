package com.ydgk.ssm.service;

import com.ydgk.ssm.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-24 11:33
 */
@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public void testMethod(){
        System.out.println("TestService.testMethod");
        testDao.testMethod();
    }

}
