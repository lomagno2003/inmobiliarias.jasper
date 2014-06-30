package com.clomagno.inmobiliarias.jasper.beans.detailConsorcio;

import java.util.List;

public class JRDetailConsorcioBean {
	private String nombre;
	
	private List<PropiedadItem> propiedad;
	
	private List<GastoItem> gasto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PropiedadItem> getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(List<PropiedadItem> propiedad) {
		this.propiedad = propiedad;
	}

	public List<GastoItem> getGasto() {
		return gasto;
	}

	public void setGasto(List<GastoItem> gasto) {
		this.gasto = gasto;
	}
}
