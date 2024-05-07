package com.suseok.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.suseok.run.model.dao","com.suseok.record.model.dao"})
public class DBConfig {

}
