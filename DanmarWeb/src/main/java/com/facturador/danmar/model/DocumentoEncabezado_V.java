package com.facturador.danmar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="documentoencabezados_v")
public class DocumentoEncabezado_V {

	@Id
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Fecha")
	private Date fecha;
	
	@Column(name = "Letra")
	private String letra;

	@Column(name = "FacturaNumero")
	private String facturaNumero;
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "EstadoCodigo")
	private String estadoCodigo;
	@Column(name = "EstadoNombre")
	private String estadoNombre;

	@Column(name = "TipoDocumentoNombre")
	private String tipoDocumentoNombre;
	@Column(name = "TipoDocumentoCodigo")
	private String tipoDocumentoCodigo;
	
	@Column(name = "clienteNumero")
	private int clienteNro;
	@Column(name = "clienteCategoria")
	private Integer clienteCategoria;
	@Column(name = "clienteRazonSocial")
	private String clienteRazonSocial;
	@Column(name = "clienteCuit")
	private String clienteCuit;

	
	
	@Column(name = "TotalArticulos")
	private Double totalArticulos;
	@Column(name = "TotalImpuestos")
	private Double totalImpuestos;
	@Column(name = "TotalDocumento")
	private Double totalDocumento;
	
	

	public Integer getClienteCategoria() {
		return clienteCategoria;
	}
	public void setClienteCategoria(Integer clienteCategoria) {
		this.clienteCategoria = clienteCategoria;
	}
	public String getClienteRazonSocial() {
		return clienteRazonSocial;
	}
	public void setClienteRazonSocial(String clienteRazonSocial) {
		this.clienteRazonSocial = clienteRazonSocial;
	}
	public String getClienteCuit() {
		return clienteCuit;
	}
	public void setClienteCuit(String clienteCuit) {
		this.clienteCuit = clienteCuit;
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

	public String getFacturaNumero() {
		return facturaNumero;
	}
	public void setFacturaNumero(String facturaNumero) {
		this.facturaNumero = facturaNumero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstadoCodigo() {
		return estadoCodigo;
	}
	public void setEstadoCodigo(String estadoCodigo) {
		this.estadoCodigo = estadoCodigo;
	}
	public String getEstadoNombre() {
		return estadoNombre;
	}
	public void setEstadoNombre(String estadoNombre) {
		this.estadoNombre = estadoNombre;
	}
	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}
	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	public String getTipoDocumentoCodigo() {
		return tipoDocumentoCodigo;
	}
	public void setTipoDocumentoCodigo(String tipoDocumentoCodigo) {
		this.tipoDocumentoCodigo = tipoDocumentoCodigo;
	}
	public int getClienteNro() {
		return clienteNro;
	}
	public void setClienteNro(int clienteNro) {
		this.clienteNro = clienteNro;
	}
	public Double getTotalArticulos() {
		return totalArticulos;
	}
	public void setTotalArticulos(Double totalArticulos) {
		this.totalArticulos = totalArticulos;
	}
	public Double getTotalImpuestos() {
		return totalImpuestos;
	}
	public void setTotalImpuestos(Double totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}
	public Double getTotalDocumento() {
		return totalDocumento;
	}
	public void setTotalDocumento(Double totalDocumento) {
		this.totalDocumento = totalDocumento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
}
