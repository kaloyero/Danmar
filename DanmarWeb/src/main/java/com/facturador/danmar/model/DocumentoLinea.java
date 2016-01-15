package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="documentolineas")
public class DocumentoLinea {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "cantidad")
	private int cantidad	;
	@Column(name = "precio")
	private Double precio;
	@Column(name = "precioUnitario")
	private Double precioUnitario;
	@Column(name = "IdDocumentoEncabezado")
	private int documentoEncabezadoId;
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "CC1")
	private String cc1	;	
	@Column(name = "CC2")
	private String cc2	;
	@Column(name = "CC3")
	private String cc3	;
	@Column(name = "CC4")
	private String cc4	;
	@Column(name = "CC5")
	private String cc5		;
	@Column(name = "PrecioTC")
	private Double precioTC	;
	@Column(name = "IdArticulo")
	private int articuloId;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getDocumentoEncabezadoId() {
		return documentoEncabezadoId;
	}
	public void setDocumentoEncabezadoId(int documentoEncabezadoId) {
		this.documentoEncabezadoId = documentoEncabezadoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCc1() {
		return cc1;
	}
	public void setCc1(String cc1) {
		this.cc1 = cc1;
	}
	public String getCc2() {
		return cc2;
	}
	public void setCc2(String cc2) {
		this.cc2 = cc2;
	}
	public String getCc3() {
		return cc3;
	}
	public void setCc3(String cc3) {
		this.cc3 = cc3;
	}
	public String getCc4() {
		return cc4;
	}
	public void setCc4(String cc4) {
		this.cc4 = cc4;
	}
	public String getCc5() {
		return cc5;
	}
	public void setCc5(String cc5) {
		this.cc5 = cc5;
	}
	public Double getPrecioTC() {
		return precioTC;
	}
	public void setPrecioTC(Double precioTC) {
		this.precioTC = precioTC;
	}
	public int getArticuloId() {
		return articuloId;
	}
	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}
	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	
	
}
