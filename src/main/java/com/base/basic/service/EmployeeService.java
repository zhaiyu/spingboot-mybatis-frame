package com.base.basic.service;

import com.base.basic.mapper.EmployeeMapper;
import com.base.basic.model.Employee;
import com.base.basic.model.EmployeeExample;
import java.util.List;

import com.base.utils.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jesse
 * @date 2018/1/23
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     *  查询全部 Employee
     */
    public List<Employee> findAll() {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        return employeeMapper.selectByExample(example);
    }

    /**
     *  分页查询Employee
     */
    public PageBean<Employee> findByPage(Integer currentPage,Integer pageSize,String name) {
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        int countNums= employeeMapper.countByExample(example);
        if(StringUtils.isNotEmpty(name)) {
            criteria.andNameEqualTo(name);
        }
        PageHelper.startPage(currentPage,pageSize);
        List<Employee> employeeList =  employeeMapper.selectByExample(example);
        PageBean<Employee> pageBean = new PageBean(currentPage,pageSize,countNums);
        pageBean.setItems(employeeList);
        return pageBean;
    }

}
