package com.danmar.dbf.dto;

import java.util.Date;

public class ArticuloDto {

//	private String codigo;
//	private String subcodigo;
	private String  cc1;
	private String 	cc2;
	private String 	cc3;
	private String 	cc4;
	private String 	cc5;
	private String 	recambio;
	private String 	articulo;
	private String 	descuentoAdicional;
//	private String 	descamplia;
	private String 	tipo; //tipo de articulo
	private String 	linea;
	private Double 	precioLp;
	private Double 	costo;
	private Double 	precio;
	private Double 	precioMayorista;
	private String 	manoDeObra;
	private String 	tiempo;
	private String 	existentes;
	private String 	reservados;
	private Integer 	canMaxima;
	private Integer 	canMinima;
	private String 	descuentos;
	private Double 	ganancia;
	private Double 	gananciaMy;
	private Double 	listaPrecioAux;
	private String 	origen;
	private Date 	fechaCompra;
	private Integer 	facturaCompra;
	private String 	proveedor;
	private String 	descuentoProv1;
	private String 	descuentoProv2;
	private String 	codigoProv;
	private String 	monedaCos;
	private Date 	fCamprec;
	private String 	variacion;
	private String 	varMin;
	private String 	varMay;
	private Date 	fVarmin	;
	private Date fVarmay;
	private String 	visible;
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
	public String getRecambio() {
		return recambio;
	}
	public void setRecambio(String recambio) {
		this.recambio = recambio;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getDescuentoAdicional() {
		return descuentoAdicional;
	}
	public void setDescuentoAdicional(String descuentoAdicional) {
		this.descuentoAdicional = descuentoAdicional;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	public Double getPrecioLp() {
		return precioLp;
	}
	public void setPrecioLp(Double precioLp) {
		this.precioLp = precioLp;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Double getPrecioMayorista() {
		return precioMayorista;
	}
	public void setPrecioMayorista(Double precioMayorista) {
		this.precioMayorista = precioMayorista;
	}
	public String getManoDeObra() {
		return manoDeObra;
	}
	public void setManoDeObra(String manoDeObra) {
		this.manoDeObra = manoDeObra;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getExistentes() {
		return existentes;
	}
	public void setExistentes(String existentes) {
		this.existentes = existentes;
	}
	public String getReservados() {
		return reservados;
	}
	public void setReservados(String reservados) {
		this.reservados = reservados;
	}
	public Integer getCanMaxima() {
		return canMaxima;
	}
	public void setCanMaxima(Integer canMaxima) {
		this.canMaxima = canMaxima;
	}
	public Integer getCanMinima() {
		return canMinima;
	}
	public void setCanMinima(Integer canMinima) {
		this.canMinima = canMinima;
	}
	public String getDescuentos() {
		return descuentos;
	}
	public void setDescuentos(String descuentos) {
		this.descuentos = descuentos;
	}
	public Double getGanancia() {
		return ganancia;
	}
	public void setGanancia(Double ganancia) {
		this.ganancia = ganancia;
	}
	public Double getGananciaMy() {
		return gananciaMy;
	}
	public void setGananciaMy(Double gananciaMy) {
		this.gananciaMy = gananciaMy;
	}
	public Double getListaPrecioAux() {
		return listaPrecioAux;
	}
	public void setListaPrecioAux(Double listaPrecioAux) {
		this.listaPrecioAux = listaPrecioAux;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public Integer getFacturaCompra() {
		return facturaCompra;
	}
	public void setFacturaCompra(Integer facturaCompra) {
		this.facturaCompra = facturaCompra;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getDescuentoProv1() {
		return descuentoProv1;
	}
	public void setDescuentoProv1(String descuentoProv1) {
		this.descuentoProv1 = descuentoProv1;
	}
	public String getDescuentoProv2() {
		return descuentoProv2;
	}
	public void setDescuentoProv2(String descuentoProv2) {
		this.descuentoProv2 = descuentoProv2;
	}
	public String getCodigoProv() {
		return codigoProv;
	}
	public void setCodigoProv(String codigoProv) {
		this.codigoProv = codigoProv;
	}
	public String getMonedaCos() {
		return monedaCos;
	}
	public void setMonedaCos(String monedaCos) {
		this.monedaCos = monedaCos;
	}
	public Date getfCamprec() {
		return fCamprec;
	}
	public void setfCamprec(Date fCamprec) {
		this.fCamprec = fCamprec;
	}
	public String getVariacion() {
		return variacion;
	}
	public void setVariacion(String variacion) {
		this.variacion = variacion;
	}
	public String getVarMin() {
		return varMin;
	}
	public void setVarMin(String varMin) {
		this.varMin = varMin;
	}
	public String getVarMay() {
		return varMay;
	}
	public void setVarMay(String varMay) {
		this.varMay = varMay;
	}
	public Date getfVarmin() {
		return fVarmin;
	}
	public void setfVarmin(Date fVarmin) {
		this.fVarmin = fVarmin;
	}
	public Date getfVarmay() {
		return fVarmay;
	}
	public void setfVarmay(Date fVarmay) {
		this.fVarmay = fVarmay;
	}
	public String getVisible() {
		return visible;
	}
	public void setVisible(String visible) {
		this.visible = visible;
	}


	
}


