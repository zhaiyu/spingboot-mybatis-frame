package com.base.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

/**
 * @author Jesse
 * @date 2018/1/22
 */
@Component
@MapperScan("com.base.*.mapper")
public class MyBatisConfiguration {

}
