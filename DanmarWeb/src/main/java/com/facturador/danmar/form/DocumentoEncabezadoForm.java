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
	private String  estadoCodigo;
	private String  estadoNombre;
	private String  fechaCreacion;
	private String  fechaActualiza;
	private String  usuarioCreadorId;
	private String  usuarioActualizaId;
	private String  tipoDocumentoId;
	private String  tipoDocumentoCodigo;
	private String  tipoDocumentoNombre;
	private String  clienteNro;
	private String  clienteNombre;
	private String  clienteCategoria;
	private String  clienteCategoriaNombre;
	private String  clienteCuit;
	private String  clienteIvaInscripto;
	private String totalArticulos;
	private String totalImpuestos;
	private String totalDocumento;	
	private String pagoEfectivoMonto;
	private String pagoTarjetaNombre;
	private String pagoTarjetaCoefRecargoTC;
	private String pagoTarjetaMonto;
	private String pagoTarjetaMontoConInteres;
	private String pagoTarjetaCupon;
	private String pagoTarjetaCuotas;

	
	
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
	public String getTotalArticulos() {
		return totalArticulos;
	}
	public void setTotalArticulos(String totalArticulos) {
		this.totalArticulos = totalArticulos;
	}
	public String getTotalImpuestos() {
		return totalImpuestos;
	}
	public void setTotalImpuestos(String totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}
	public String getTotalDocumento() {
		return totalDocumento;
	}
	public void setTotalDocumento(String totalDocumento) {
		this.totalDocumento = totalDocumento;
	}
	public String getTipoDocumentoCodigo() {
		return tipoDocumentoCodigo;
	}
	public void setTipoDocumentoCodigo(String tipoDocumentoCodigo) {
		this.tipoDocumentoCodigo = tipoDocumentoCodigo;
	}
	public String getTipoDocumentoNombre() {
		return tipoDocumentoNombre;
	}
	public void setTipoDocumentoNombre(String tipoDocumentoNombre) {
		this.tipoDocumentoNombre = tipoDocumentoNombre;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public String getClienteCategoria() {
		return clienteCategoria;
	}
	public void setClienteCategoria(String clienteCategoria) {
		this.clienteCategoria = clienteCategoria;
	}
	public String getClienteCuit() {
		return clienteCuit;
	}
	public void setClienteCuit(String clienteCuit) {
		this.clienteCuit = clienteCuit;
	}
	public String getPagoEfectivoMonto() {
		return pagoEfectivoMonto;
	}
	public void setPagoEfectivoMonto(String pagoEfectivoMonto) {
		this.pagoEfectivoMonto = pagoEfectivoMonto;
	}
	public String getPagoTarjetaNombre() {
		return pagoTarjetaNombre;
	}
	public void setPagoTarjetaNombre(String pagoTarjetaNombre) {
		this.pagoTarjetaNombre = pagoTarjetaNombre;
	}
	public String getPagoTarjetaMonto() {
		return pagoTarjetaMonto;
	}
	public void setPagoTarjetaMonto(String pagoTarjetaMonto) {
		this.pagoTarjetaMonto = pagoTarjetaMonto;
	}
	public String getPagoTarjetaMontoConInteres() {
		return pagoTarjetaMontoConInteres;
	}
	public void setPagoTarjetaMontoConInteres(String pagoTarjetaMontoConInteres) {
		this.pagoTarjetaMontoConInteres = pagoTarjetaMontoConInteres;
	}
	public String getPagoTarjetaCupon() {
		return pagoTarjetaCupon;
	}
	public void setPagoTarjetaCupon(String pagoTarjetaCupon) {
		this.pagoTarjetaCupon = pagoTarjetaCupon;
	}
	public String getPagoTarjetaCuotas() {
		return pagoTarjetaCuotas;
	}
	public void setPagoTarjetaCuotas(String pagoTarjetaCuotas) {
		this.pagoTarjetaCuotas = pagoTarjetaCuotas;
	}
	public String getClienteIvaInscripto() {
		return clienteIvaInscripto;
	}
	public void setClienteIvaInscripto(String clienteIvaInscripto) {
		this.clienteIvaInscripto = clienteIvaInscripto;
	}
	public String getPagoTarjetaCoefRecargoTC() {
		return pagoTarjetaCoefRecargoTC;
	}
	public void setPagoTarjetaCoefRecargoTC(String pagoTarjetaCoefRecargoTC) {
		this.pagoTarjetaCoefRecargoTC = pagoTarjetaCoefRecargoTC;
	}
	public String getClienteCategoriaNombre() {
		return clienteCategoriaNombre;
	}
	public void setClienteCategoriaNombre(String clienteCategoriaNombre) {
		this.clienteCategoriaNombre = clienteCategoriaNombre;
	}
	

}
