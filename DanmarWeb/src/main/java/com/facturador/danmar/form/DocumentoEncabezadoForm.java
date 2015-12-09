package com.facturador.danmar.form;

import java.util.ArrayList;
import java.util.List;

public class DocumentoEncabezadoForm implements Form{

	private static final long serialVersionUID = 1L;

	private int id;

	private String  fecha;
	private String  letra;
	private String  sucursalId;
	private String  numero;
	private String  descripcion;
	private String  estadoId;
	private String  fechaCreacion;
	private String  fechaActualiza;
	private String  usuarioCreadorId;
	private String  usuarioActualizaId;
	private String  tipoDocumentoId;
	private String  clienteNro;
	
	private List<DocumentoLineaForm> lineas = new ArrayList<DocumentoLineaForm>();
	private List<DocumentoPagoForm> pagos = new ArrayList<DocumentoPagoForm>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getSucursalId() {
		return sucursalId;
	}
	public void setSucursalId(String sucursalId) {
		this.sucursalId = sucursalId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstadoId() {
		return estadoId;
	}
	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaActualiza() {
		return fechaActualiza;
	}
	public void setFechaActualiza(String fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}
	public String getUsuarioCreadorId() {
		return usuarioCreadorId;
	}
	public void setUsuarioCreadorId(String usuarioCreadorId) {
		this.usuarioCreadorId = usuarioCreadorId;
	}
	public String getUsuarioActualizaId() {
		return usuarioActualizaId;
	}
	public void setUsuarioActualizaId(String usuarioActualizaId) {
		this.usuarioActualizaId = usuarioActualizaId;
	}
	public String getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	public void setTipoDocumentoId(String tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	public String getClienteNro() {
		return clienteNro;
	}
	public void setClienteNro(String clienteNro) {
		this.clienteNro = clienteNro;
	}
	public List<DocumentoLineaForm> getLineas() {
		return lineas;
	}
	public void setLineas(List<DocumentoLineaForm> lineas) {
		this.lineas = lineas;
	}
	public List<DocumentoPagoForm> getPagos() {
		return pagos;
	}
	public void setPagos(List<DocumentoPagoForm> pagos) {
		this.pagos = pagos;
	}
	
	

}
