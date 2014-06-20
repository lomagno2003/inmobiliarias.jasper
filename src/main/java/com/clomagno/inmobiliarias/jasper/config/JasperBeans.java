package com.clomagno.inmobiliarias.jasper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Configuration
public class JasperBeans {
	@Bean
	public JasperReportsPdfView getPdfReport(){
		JasperReportsPdfView result = new JasperReportsPdfView();
		result.addStaticAttribute("reportDataKey", "datasource");
		result.addStaticAttribute("url","classpath:testReport.jrxml");
		return result;
	}
}
