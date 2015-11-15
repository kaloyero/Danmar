package com.danmar.dbf.dto.filtro;

import java.util.Date;

import com.danmar.filtro.Paginacion;

public class FiltroCliente extends Paginacion{

	private int codigo;
	private String tipo; // Tipo de cliente
	private String nombre;
	private String 	razonSocial;
	private String 	cuit;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	
	
	
}
