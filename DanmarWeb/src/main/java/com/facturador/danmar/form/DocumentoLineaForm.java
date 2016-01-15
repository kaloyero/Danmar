package com.facturador.danmar.form;


public class DocumentoLineaForm implements Form{

	private static final long serialVersionUID = 1L;

	private int id;
	private int  encabezadoId;
	private int  articuloId;
	private String  articulo;
	private String  codigo;
	private String  cc1;
	private String  cc2;
	private String  cc3;
	private String  cc4;
	private String  cc5;
	private String  descripcion;
	private String  cantidad;
	private String  precio;
	private String  precioUnitario;
	private String  precioTC;
	private String totalArticulos;
	private String totalImpuestos;
	private String totalLinea;
	
	
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
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getTotalArticulos() {
		return totalArticulos;
	}
	public void setTotalArticulos(String totalArticulos) {
		this.totalArticulos = totalArticulos;
	}
	public String getTotalImpuestos() {
		return totalImpuestos;
	}
	public void setTotalImpuestos(String totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}
	public String getTotalLinea() {
		return totalLinea;
	}
	public void setTotalLinea(String totalLinea) {
		this.totalLinea = totalLinea;
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
	public String getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
