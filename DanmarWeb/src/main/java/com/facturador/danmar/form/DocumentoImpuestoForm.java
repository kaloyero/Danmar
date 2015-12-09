package com.facturador.danmar.form;

public class DocumentoImpuestoForm implements Form{

	private static final long serialVersionUID = 1L;
	private int id;

	private String alicuota;
	private Double alicuotaNum;
	private String importe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAlicuota() {
		return alicuota;
	}
	public void setAlicuota(String alicuota) {
		this.alicuota = alicuota;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public Double getAlicuotaNum() {
		return alicuotaNum;
	}
	public void setAlicuotaNum(Double alicuotaNum) {
		this.alicuotaNum = alicuotaNum;
	}

	
	
}
