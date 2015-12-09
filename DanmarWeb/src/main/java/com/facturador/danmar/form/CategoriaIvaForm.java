package com.facturador.danmar.form;

public class CategoriaIvaForm implements Form{

	private static final long serialVersionUID = 1L;
	private int id;
	private int categoria;
	private String nombre;
	private String alicuota;
	private Double alicuotaNum;

	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAlicuota() {
		return alicuota;
	}
	public void setAlicuota(String alicuota) {
		this.alicuota = alicuota;
	}
	public Double getAlicuotaNum() {
		return alicuotaNum;
	}
	public void setAlicuotaNum(Double alicuotaNum) {
		this.alicuotaNum = alicuotaNum;
	}
	
	

}
