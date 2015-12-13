package com.facturador.danmar.form;

public class DocumentoLineaForm implements Form{

	private static final long serialVersionUID = 1L;

	private int id;
	private int  encabezadoId;
	private int  articuloId;
	private String  codigo;
	private String  descripcion;
	private String  cantidad;
	private String  precio;
	private String  precioTC;
	
	
	
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public int getEncabezadoId() {
		return encabezadoId;
	}
	public void setEncabezadoId(int encabezadoId) {
		this.encabezadoId = encabezadoId;
	}
	public int getArticuloId() {
		return articuloId;
	}
	public void setArticuloId(int articuloId) {
		this.articuloId = articuloId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecioTC() {
		return precioTC;
	}
	public void setPrecioTC(String precioTC) {
		this.precioTC = precioTC;
	}
	
	
}
