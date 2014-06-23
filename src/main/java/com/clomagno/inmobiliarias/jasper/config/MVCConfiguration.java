package com.clomagno.inmobiliarias.jasper.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ComponentScan(basePackages = "com.clomagno.inmobiliarias.jasper.controllers")
@Configuration
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter {
	
}
