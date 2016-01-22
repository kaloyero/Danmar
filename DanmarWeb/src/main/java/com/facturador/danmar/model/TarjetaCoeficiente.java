package com.facturador.danmar.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity(name="tarjeta_coeficientes")
public class TarjetaCoeficiente  {

	@EmbeddedId
	private TarjetaCuotaGroupId tarjetaCuota;
	
	@Column(name = "coeficiente")
	private Double coeficiente;

	public TarjetaCuotaGroupId getTarjetaCuota() {
		return tarjetaCuota;
	}

	public void setTarjetaCuota(TarjetaCuotaGroupId tarjetaCuota) {
		this.tarjetaCuota = tarjetaCuota;
	}

	public Double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}

	
}
