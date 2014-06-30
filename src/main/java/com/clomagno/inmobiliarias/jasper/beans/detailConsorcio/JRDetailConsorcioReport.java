package com.clomagno.inmobiliarias.jasper.beans.detailConsorcio;

import com.clomagno.inmobiliarias.jasper.beans.JRBeanReport;

public class JRDetailConsorcioReport extends JRBeanReport{
	@Override
	public String getJRName() {
		return "detailConsorcio";
	}

	@Override
	public String getJRXMLPath() {
		return "detailConsorcio.jrxml";
	}

	@Override
	public Class<?> getBeanType() {
		return JRDetailConsorcioBean.class;
	}
}
