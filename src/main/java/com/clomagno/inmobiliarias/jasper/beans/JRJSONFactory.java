package com.clomagno.inmobiliarias.jasper.beans;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JRJSONFactory {
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public JRBeanReport create(String reportName, String json) throws JsonParseException, JsonMappingException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		System.out.println(this.getClass().getPackage().getName());
		String classPrefix = this.getClass().getPackage().getName() + "."+reportName+".JR";
		String className = reportName.substring(0, 1).toUpperCase() + reportName.substring(1);
		String classSufix = "Report";
		
		String classFullName = classPrefix + className + classSufix;
		return create(Class.forName(classFullName),json);
	}
	
	public JRBeanReport create(Class<?> reportType, String json) throws InstantiationException, IllegalAccessException, JsonParseException, JsonMappingException, IOException{
		JRBeanReport report = (JRBeanReport) reportType.newInstance();
		
		report.setJRBean(objectMapper.readValue(json, report.getBeanType()));
		
		return report;
	}
}
