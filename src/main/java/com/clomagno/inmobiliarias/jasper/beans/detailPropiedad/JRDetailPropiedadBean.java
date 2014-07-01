package com.clomagno.inmobiliarias.jasper.beans.detailPropiedad;

import java.util.List;

import com.clomagno.inmobiliarias.jasper.beans.detailConsorcio.GastoItem;

public class JRDetailPropiedadBean {
	private String nombre;
	
	private String direccion;
	
	private String porcentajeGastosComunes;
	
	private String consorcio;
	
	private String propietario;
	
	private List<GastoItem> gasto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPorcentajeGastosComunes() {
		return porcentajeGastosComunes;
	}

	public void setPorcentajeGastosComunes(String porcentajeGastosComunes) {
		this.porcentajeGastosComunes = porcentajeGastosComunes;
	}

	public String getConsorcio() {
		return consorcio;
	}

	public void setConsorcio(String consorcio) {
		this.consorcio = consorcio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	public List<GastoItem> getGasto() {
		return gasto;
	}

	public void setGasto(List<GastoItem> gasto) {
		this.gasto = gasto;
	}
}
