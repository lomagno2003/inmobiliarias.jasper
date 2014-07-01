package com.clomagno.inmobiliarias.jasper.beans;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JRJSONFactory {
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * This method creates a new JRBeanReport based on the ConventionOverConfiguration paradigm to found the corresponding report class
	 * @param reportName
	 * @param json
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public JRBeanReport create(String reportName, String json) throws JsonParseException, JsonMappingException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		//First configure prefix, body and suffix of the report classpath, and classname
		String classPrefix = this.getClass().getPackage().getName() + "."+reportName+".JR";
		String className = reportName.substring(0, 1).toUpperCase() + reportName.substring(1);
		String classSufix = "Report";
		
		//Concatenate them and call the create method but this time, specifying the corresponding class
		String classFullName = classPrefix + className + classSufix;
		return create(Class.forName(classFullName),json);
	}
	
	/**
	 * This method creates a new JRBeanReport based on the class passed as argument
	 * @param reportType
	 * @param json
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public JRBeanReport create(Class<?> reportType, String json) throws InstantiationException, IllegalAccessException, JsonParseException, JsonMappingException, IOException{
		JRBeanReport report = (JRBeanReport) reportType.newInstance();
		
		report.setJRBean(objectMapper.readValue(json, report.getBeanType()));
		
		return report;
	}
}
