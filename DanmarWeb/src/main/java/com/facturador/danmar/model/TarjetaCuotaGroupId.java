package com.facturador.danmar.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TarjetaCuotaGroupId implements Serializable {
	private static final long serialVersionUID = 3965783197805260008L;

	@Column(name = "id_tarjeta")
	private int tarjetaId;
	
	@Column(name = "cuotas")
	private int cuotas;

	public int getTarjetaId() {
		return tarjetaId;
	}

	public void setTarjetaId(int tarjetaId) {
		this.tarjetaId = tarjetaId;
	}

	public int getCuotas() {
		return cuotas;
	}

	public void setCuotas(int cuotas) {
		this.cuotas = cuotas;
	}

	
}


