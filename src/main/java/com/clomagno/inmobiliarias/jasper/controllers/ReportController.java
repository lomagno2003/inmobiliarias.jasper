package com.clomagno.inmobiliarias.jasper.controllers;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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

import com.clomagno.inmobiliarias.jasper.beans.JRBeanReport;
import com.clomagno.inmobiliarias.jasper.beans.JRJSONFactory;
import com.clomagno.inmobiliarias.jasper.beans.detailConsorcio.JRDetailConsorcioBean;
import com.clomagno.inmobiliarias.jasper.beans.detailConsorcio.JRDetailConsorcioReport;
import com.clomagno.inmobiliarias.jasper.beans.detailConsorcio.PropiedadItem;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
 
@Controller
@RequestMapping("/report/**")
public class ReportController {
	private JRJSONFactory factory = new JRJSONFactory();
	
	private class UnknowOutputFormatException extends Exception{
		private static final long serialVersionUID = -6005975200765326940L;		
	}
	
	@Autowired private ApplicationContext appContext;

	@RequestMapping(value = "/{outputFormat}", method = RequestMethod.GET)
	public ModelAndView getReport(@PathVariable("outputFormat") String outputFormat,@RequestParam("reportName") String reportName,@RequestParam("body") String body) {
		try {
			body = java.net.URLDecoder.decode(body, "UTF-8");
			System.out.println("Printing:");
			System.out.println(body);
			System.out.println();
			
			Collection<Object> beanCollection = new Vector<Object>();

			JRBeanReport report = factory.create(reportName, body);
			
			beanCollection.add(report.getJRBean());
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(beanCollection);

			AbstractJasperReportsSingleFormatView view;
			
			switch(outputFormat){
			case "pdf":
				view = new JasperReportsPdfView();
				break;
			default:
				throw new UnknowOutputFormatException();
			}
			
		    view.setUrl("classpath:"+report.getJRXMLPath());
		    
		    Map<String, Object> params = new HashMap<>();        
	        params.put("datasource", dataSource);
	        
	        view.setReportDataKey("datasource");
		    view.setApplicationContext(appContext);
		    
		    return new ModelAndView(view, params);
		} catch (UnknowOutputFormatException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}