package com.clomagno.inmobiliarias.jasper.beans.detailPropiedad;

import com.clomagno.inmobiliarias.jasper.beans.JRBeanReport;

public class JRDetailPropiedadReport extends JRBeanReport{
	@Override
	public String getJRName() {
		return "detailPropiedad";
	}

	@Override
	public String getJRXMLPath() {
		return "detailPropiedad.jrxml";
	}

	@Override
	public Class<?> getBeanType() {
		return JRDetailPropiedadBean.class;
	}
}
