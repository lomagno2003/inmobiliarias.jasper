package com.clomagno.inmobiliarias.jasper.controllers;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JsonDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.AbstractJasperReportsSingleFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
 
@Controller
@RequestMapping("/report/**")
public class ReportController {
	private class UnknowOutputFormatException extends Exception{
		private static final long serialVersionUID = -6005975200765326940L;		
	}
	
	@Autowired private ApplicationContext appContext;

	@RequestMapping(value = "/{outputFormat}", method = RequestMethod.GET)
	public ModelAndView getReport(@PathVariable("outputFormat") String outputFormat,@RequestParam("reportName") String reportName,@RequestParam("body") String body) {
		try {
			InputStream inputStream = new ByteArrayInputStream(body.getBytes());
			JsonDataSource dataSource = new JsonDataSource(inputStream);
			
			AbstractJasperReportsSingleFormatView view;
			
			switch(outputFormat){
			case "pdf":
				view = new JasperReportsPdfView();
				break;
			default:
				throw new UnknowOutputFormatException();
			}
			
		    view.setUrl("classpath:"+reportName+".jrxml");
		    
		    Map<String, Object> params = new HashMap<>();        
	        params.put("datasource", dataSource);
	        
	        view.setReportDataKey("datasource");
		    view.setApplicationContext(appContext);
		    
		    return new ModelAndView(view, params);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (UnknowOutputFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
}