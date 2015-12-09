package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="documentoPagos")
public class DocumentoPago {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "idTipoPago")
	private int tipoPago;	
	
	@Column(name = "idDocumentoEncabezado")
	private int documentoEncabezado;
	
	@Column(name = "importe")
	private Double importe;
	
	@Column(name = "cuotas")
	private int cuotas;
	
	@Column(name = "coeficiente")
	private Double coeficiente;
	
	@Column(name = "NroCupon")
	private String nroCupon;
	
	@Column(name = "tarjeta")
	private int tarjeta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(int tipoPago) {
		this.tipoPago = tipoPago;
	}

	public int getDocumentoEncabezado() {
		return documentoEncabezado;
	}

	public void setDocumentoEncabezado(int documentoEncabezado) {
		this.documentoEncabezado = documentoEncabezado;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	public Double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public String getNroCupon() {
		return nroCupon;
	}

	public void setNroCupon(String nroCupon) {
		this.nroCupon = nroCupon;
	}

	public int getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(int tarjeta) {
		this.tarjeta = tarjeta;
	}


	
	
}
