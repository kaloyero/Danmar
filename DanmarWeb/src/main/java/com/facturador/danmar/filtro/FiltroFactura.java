package com.facturador.danmar.filtro;

import com.danmar.filtro.Paginacion;

public class FiltroFactura extends Paginacion{

	private String codigoFactura;
	private String numeroFactura;
	private String fechaDesde;
	private String FechaHasta;
	
	public String getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return FechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		FechaHasta = fechaHasta;
	}
	
	
}
