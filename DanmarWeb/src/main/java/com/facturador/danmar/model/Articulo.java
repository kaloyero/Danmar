package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="articulo")
public class Articulo {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "cc1")
	private String  cc1;
	@Column(name = "cc2")
	private String 	cc2;
	@Column(name = "cc3")
	private String 	cc3;
	@Column(name = "cc4")
	private String 	cc4;
	@Column(name = "cc5")
	private String 	cc5;
	@Column(name = "articulo")
	private String 	articulo;
	@Column(name = "tipo")
	private String 	tipo; 
	@Column(name = "precio")
	private Double 	precio;
//	private String 	visible;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	
}
