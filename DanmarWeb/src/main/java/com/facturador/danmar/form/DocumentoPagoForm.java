package com.facturador.danmar.form;

public class DocumentoPagoForm implements Form{

	private static final long serialVersionUID = 1L;

	private int id;
	private int documentoEncabezado;
	private String tipoPago;	
	private String importe;
	private String cuotas;
	private String coeficiente;
	private String coefRecargoTC;
	private String cupon;
	private String tarjeta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDocumentoEncabezado() {
		return documentoEncabezado;
	}
	public void setDocumentoEncabezado(int documentoEncabezado) {
		this.documentoEncabezado = documentoEncabezado;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
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
	public String getCupon() {
		return cupon;
	}
	public void setCupon(String cupon) {
		this.cupon = cupon;
	}
	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getCoefRecargoTC() {
		return coefRecargoTC;
	}
	public void setCoefRecargoTC(String coefRecargoTC) {
		this.coefRecargoTC = coefRecargoTC;
	}

	
	


}
