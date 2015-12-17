package com.facturador.danmar.form;

public class TarjetaForm {

	private String codigo;
	
	private String cuotas;
	
	private String monto;
	
	private String coeficiente;

	private String descripcion;


	public TarjetaForm(String codigo, String cuotas, String coeficiente) {
		super();
		this.codigo = codigo;
		this.cuotas = cuotas;
		this.coeficiente = coeficiente;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCuotas() {
		return cuotas;
	}

	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}

	public String getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(String coeficiente) {
		this.coeficiente = coeficiente;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
}
