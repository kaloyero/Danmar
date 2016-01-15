package com.danmar.filtro;

public class Paginacion extends NoPaginacion {

	private int pagina ;
	private int cantRegistros ;
	private String orderBy;
	

	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public int getCantRegistros() {
		return cantRegistros;
	}
	public void setCantRegistros(int cantRegistros) {
		this.cantRegistros = cantRegistros;
	}
	
}
