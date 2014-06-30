package com.clomagno.inmobiliarias.jasper.beans;

public abstract class JRBeanReport {
	private Object jrBean;

	public abstract String getJRName();
	
	public abstract String getJRXMLPath();
	
	public abstract Class<?> getBeanType();
	
	public Object getJRBean(){
		return jrBean;
	}
	
	public void setJRBean(Object jrBean){
		this.jrBean = jrBean;
	}
}
