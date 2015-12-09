package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="documentopagos")
public class Estados {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "IdTipoPago")
	private int tipoPagoId	;
	@Column(name = "IdDocumentoEncabezado")
	private int documentoEncabezadoId;
	@Column(name = "Importe")
	private Double importe;
	@Column(name = "Cuotas")
	private Integer cuotas;
	@Column(name = "Coeficiente")
	private Double coeficiente	;	
	@Column(name = "NroCupon")
	private String cuponNro	;
	@Column(name = "Tarjeta")
	private Integer tarjeta	;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipoPagoId() {
		return tipoPagoId;
	}
	public void setTipoPagoId(int tipoPagoId) {
		this.tipoPagoId = tipoPagoId;
	}
	public int getDocumentoEncabezadoId() {
		return documentoEncabezadoId;
	}
	public void setDocumentoEncabezadoId(int documentoEncabezadoId) {
		this.documentoEncabezadoId = documentoEncabezadoId;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	public Double getCoeficiente() {
		return coeficiente;
	}
	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}
	public String getCuponNro() {
		return cuponNro;
	}
	public void setCuponNro(String cuponNro) {
		this.cuponNro = cuponNro;
	}
	public Integer getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Integer tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
}
