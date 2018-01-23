package com.base.basic.controller;

import com.base.basic.model.Employee;
import com.base.basic.service.EmployeeService;
import com.base.utils.PageBean;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jesse
 * @date 2018/1/23
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("查询全部employee数据")
    @GetMapping(value = "/emp/findAll")
    @ApiResponses({
            @ApiResponse(code=400,message="请求有误"),
            @ApiResponse(code=500,message="后台异常"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })

    @ResponseBody
    public List<Employee> findAllEmp() {
        return employeeService.findAll();
    }

    @ApiOperation("根据姓名分页查询employee数据")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "currentPage",dataType = "Integer",required = true,value = "当前页数",defaultValue = "1"),
            @ApiImplicitParam(paramType = "query",name = "pageSize",dataType = "Integer",required = true,value = "每页记录数",defaultValue = "10"),
            @ApiImplicitParam(paramType = "query",name = "name",dataType = "String",required = false,value = "姓名",defaultValue = "null")
    })
    @PostMapping(value = "/emp/findByPage")
    @ResponseBody
    public PageBean<Employee> findByPage(@RequestParam Integer currentPage, @RequestParam Integer pageSize,String name) {
        if(pageSize==null) {
            pageSize = 10;
        }
        if(currentPage==null) {
            currentPage = 1;
        }
        return employeeService.findByPage(currentPage,pageSize,name);
    }
}
