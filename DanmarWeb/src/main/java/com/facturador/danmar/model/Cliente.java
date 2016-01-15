package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="clientes")
public class Cliente {


	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "tipo_cliente")
	private int tipoCliente;
	@Column(name = "categoria")
	private int categoria;

	@Column(name = "nombre")
	private String nombre; 
	@Column(name = "razon_social")
	private String razonSocial;
	@Column(name = "direccion")
	private String 	direccion;
	@Column(name = "localidad")
	private String 	localidad;
	@Column(name = "provincia")
	private String 	provincia;
	@Column(name = "telefono")
	private String 	telefono;
	@Column(name = "cuit")
	private String 	cuit;
	@Column(name = "saldo")
	private Double 	saldo;
	@Column(name = "saldoNC")
	private Double 	saldoNC;
	@Column(name = "retencion_iibb")
	private Double 	retIIBB;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Double getSaldoNC() {
		return saldoNC;
	}
	public void setSaldoNC(Double saldoNC) {
		this.saldoNC = saldoNC;
	}
	public Double getRetIIBB() {
		return retIIBB;
	}
	public void setRetIIBB(Double retIIBB) {
		this.retIIBB = retIIBB;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	
	
}
