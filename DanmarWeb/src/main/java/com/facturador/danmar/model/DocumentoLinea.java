package com.facturador.danmar.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name="documentolineas")
public class DocumentoLinea {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "cantidad")
	private int cantidad	;
	@Column(name = "precio")
	private Double precio;
	@Column(name = "IdDocumentoEncabezado")
	private int documentoEncabezadoId;
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "PrecioFinal")
	private Double precioFinal	;
	@Column(name = "IdArticulo")
	private int articuloId;
	
//	@JoinTable(name="documentoimpuestos", joinColumns={@JoinColumn(name="IdDocumentoLinea", referencedColumnName="id", insertable=true)}
//	    , inverseJoinColumns={@JoinColumn(name="id", referencedColumnName="IdDocumentoLinea",insertable=true)})
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name = "IdDocumentoLinea",referencedColumnName="id",updatable=false,insertable=true)
//	private Set<DocumentoImpuesto> impuestos;
	
	
	
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
	public int getArticuloId() {
		return articuloId;
	}
	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}

	public Double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(Double precioFinal) {
		this.precioFinal = precioFinal;
	}
//	public Set<DocumentoImpuesto> getImpuestos() {
//		return impuestos;
//	}
//	public void setImpuestos(Set<DocumentoImpuesto> impuestos) {
//		this.impuestos = impuestos;
//	}

	
	
}
