package com.clomagno.inmobiliarias.jasper.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@ComponentScan(basePackages = "com.clomagno.inmobiliarias.jasper")
@Configuration
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter {

}
