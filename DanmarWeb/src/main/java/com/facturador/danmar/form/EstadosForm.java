package com.facturador.danmar.form;

public class EstadosForm implements Form{

	private static final long serialVersionUID = 1L;

	private int id;
	private String importe;
	private String cuotas;
	private String coeficiente	;	
	private String cuponNro	;
	private String tarjeta	;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
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
	public String getCuponNro() {
		return cuponNro;
	}
	public void setCuponNro(String cuponNro) {
		this.cuponNro = cuponNro;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	
	
}
