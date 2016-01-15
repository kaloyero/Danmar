package com.facturador.danmar.dao;

import java.util.List;

import com.facturador.danmar.model.TarjetaCoeficiente;

public interface TarjetaCoeficienteDao extends GenericDao<TarjetaCoeficiente> {

	   public List<TarjetaCoeficiente> getAllByTarjeta(int tarjeta);

		public TarjetaCoeficiente getById (int tarjeta,int cuotas);
	
}