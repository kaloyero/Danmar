package com.facturador.danmar.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="documentoencabezados")
public class DocumentoEncabezado {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "Fecha")
	private Date fecha;
	@Column(name = "Letra")
	private String letra;
	@Column(name = "Sucursal")
	private int sucursalId;
	@Column(name = "Numero")
	private int numero;
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "IdEstado")
	private int estadoId;
	@Column(name = "FechaCreacion")
	private Date fechaCreacion;
	@Column(name = "FechaActualizacion")
	private Date fechaActualiza;
	@Column(name = "IdCreadoPor")
	private int usuarioCreadorId;
	@Column(name = "IdActualizadoPor")
	private int usuarioActualizaId;
	@Column(name = "IdTipoDocumento")
	private int tipoDocumentoId;
	@Column(name = "NumeroCliente")
	private int clienteNro;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documentoEncabezadoId")
	public Set<DocumentoLinea > lineas ;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public int getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(int sucursalId) {
		this.sucursalId = sucursalId;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(int estadoId) {
		this.estadoId = estadoId;
	}
	public Date getFechaActualiza() {
		return fechaActualiza;
	}
	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}
	public int getUsuarioCreadorId() {
		return usuarioCreadorId;
	}
	public void setUsuarioCreadorId(int usuarioCreadorId) {
		this.usuarioCreadorId = usuarioCreadorId;
	}
	public int getUsuarioActualizaId() {
		return usuarioActualizaId;
	}
	public void setUsuarioActualizaId(int usuarioActualizaId) {
		this.usuarioActualizaId = usuarioActualizaId;
	}
	public int getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(int tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public int getClienteNro() {
		return clienteNro;
	}
	public void setClienteNro(int clienteNro) {
		this.clienteNro = clienteNro;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	

}
