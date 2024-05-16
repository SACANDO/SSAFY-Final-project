package com.suseok.run.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.suseok.run.basic.model.dao","com.suseok.run.core.model.dao"})
public class DBConfig {

}
