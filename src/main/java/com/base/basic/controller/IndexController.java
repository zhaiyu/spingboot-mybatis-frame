package com.base.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jesse
 * @date 2018/1/22
 */
@Controller
@Api("页面跳转相关api")
public class IndexController {

    @ApiOperation("跳转到Index页面")
    @GetMapping("/indexPage")
    public String index(){
        return "welcome";
    }
}
