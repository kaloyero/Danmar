package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="documentoimpuestos")
public class DocumentoImpuesto {

	@Id
	@GeneratedValue
	private int id;

	@Column(name = "Alicuota")
	private Double alicuota;
	@Column(name = "importe")
	private Double importe;
	@Column(name = "IdDocumentoLinea")
	private int documentoLineaId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getAlicuota() {
		return alicuota;
	}
	public void setAlicuota(Double alicuota) {
		this.alicuota = alicuota;
	}
	public Double getImporte() {
		return importe;
	}
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	public int getDocumentoLineaId() {
		return documentoLineaId;
	}
	public void setDocumentoLineaId(int documentoLineaId) {
		this.documentoLineaId = documentoLineaId;
	}

	
	
}
