package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="categoriaiva")
public class CategoriaIva {

	@Id
	@GeneratedValue
	private int categoria;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "alicuota")
	private Double alicuota;

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

	public Double getAlicuota() {
		return alicuota;
	}

	public void setAlicuota(Double alicuota) {
		this.alicuota = alicuota;
	}

	

}
