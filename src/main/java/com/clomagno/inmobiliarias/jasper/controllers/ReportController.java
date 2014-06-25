package com.clomagno.inmobiliarias.jasper.controllers;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.clomagno.inmobiliarias.jasper.models.TestModel;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
 
@Controller
@RequestMapping("/report/**")
public class ReportController {
	@Autowired private ApplicationContext appContext;

	@RequestMapping(value = "/pdf", method = RequestMethod.POST, consumes = "application/json")
	public ModelAndView getPdf(@RequestBody String array) {
		System.out.println("Imprimiendo:");
		System.out.println(array);
		
		InputStream is = new ByteArrayInputStream(array.getBytes());
		System.out.println(is.toString());
		JsonDataSource ds = null;
		try {
			ds = new JsonDataSource(is);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			System.out.println("TestError");
			e.printStackTrace();
		}
		
	    JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:testReport.jrxml");
	    
	    Map<String, Object> params = new HashMap<>();        
        params.put("datasource", ds);
        	    
        view.setReportDataKey("datasource");
	    view.setApplicationContext(appContext);
	    
	    return new ModelAndView(view, params);
	}
	
	@RequestMapping(value = "/pdf3", method = RequestMethod.GET)
	public ModelAndView getPdf3() {
		String array = "{ \"field\":\"laldsaada\"}";
		System.out.println("Imprimiendo:");
		System.out.println(array);
		
		InputStream is = new ByteArrayInputStream(array.getBytes());
		System.out.println(is.toString());
		JsonDataSource ds = null;
		try {
			ds = new JsonDataSource(is);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			System.out.println("TestError");
			e.printStackTrace();
		}
		
	    JasperReportsPdfView view = new JasperReportsPdfView();
	    view.setUrl("classpath:testReport.jrxml");
	    
	    Map<String, Object> params = new HashMap<>();        
        params.put("datasource", ds);
        	    
        view.setReportDataKey("datasource");
	    view.setApplicationContext(appContext);
	    
	    return new ModelAndView(view, params);
	}
	
    @RequestMapping("/pdf2")
    public ModelAndView generatePdfReport(ModelAndView modelAndView){ 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<TestModel> usersList = new LinkedList<TestModel>();
        usersList.add(new TestModel("hola jeje"));
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("datasource", JRdataSource);
 
        //pdfReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("pdfReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
 
    /*
 
    @RequestMapping(method = RequestMethod.GET , value = "xls")
    public ModelAndView generateXlsReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate XLS report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList = userDao.retrieveAllRegisteredUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("datasource", JRdataSource);
 
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("xlsReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
 
 
    @RequestMapping(method = RequestMethod.GET , value = "csv")
    public ModelAndView generateCsvReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate CSV report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList = userDao.retrieveAllRegisteredUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("datasource", JRdataSource);
 
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("csvReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
 
 
 
    @RequestMapping(method = RequestMethod.GET , value = "html")
    public ModelAndView generateHtmlReport(ModelAndView modelAndView){
 
        logger.debug("--------------generate HTML report----------");
 
        Map<String,Object> parameterMap = new HashMap<String,Object>();
 
        List<User> usersList = userDao.retrieveAllRegisteredUsers();
 
        JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);
 
        parameterMap.put("datasource", JRdataSource);
 
        //xlsReport bean has ben declared in the jasper-views.xml file
        modelAndView = new ModelAndView("htmlReport", parameterMap);
 
        return modelAndView;
 
    }//generatePdfReport
 */
 
}