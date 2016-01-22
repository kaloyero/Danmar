package com.facturador.danmar.form;

public class TarjetaForm {

	private String nombre;
	
	private String tarjetaId;
	
	private String codigo;
	
	private String cuotas;
	
	private String monto;
	
	private String recargo;
	
	private String coeficiente;

	private String descripcion;

	public TarjetaForm() {
		super();
	}
	public TarjetaForm(String cuotas, String coeficiente) {
		super();
		this.cuotas = cuotas;
		this.coeficiente = coeficiente;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public String getRecargo() {
		return recargo;
	}
	public void setRecargo(String recargo) {
		this.recargo = recargo;
	}
	public String getCuotas() {
		return cuotas;
	}
	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}
	public String getTarjetaId() {
		return tarjetaId;
	}
	public void setTarjetaId(String tarjetaId) {
		this.tarjetaId = tarjetaId;
	}
	
	
	
	
}
