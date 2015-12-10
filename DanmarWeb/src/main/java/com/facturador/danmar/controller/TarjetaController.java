package com.facturador.danmar.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.manager.TarjetaManager;


@Controller
public class TarjetaController {

	@Autowired
	TarjetaManager tarjetaManager;

	
	@RequestMapping(value = "/tarjeta/getAlicuota", method = RequestMethod.POST)
	public @ResponseBody  String getAlicuotaCategoriaIva(@RequestBody TarjetaForm filtro) throws ParseException{
		TarjetaForm rta = tarjetaManager.getById( ConvertionUtil.IntValueOf(filtro.getCodigo()), ConvertionUtil.IntValueOf(filtro.getCuotas()));
		return rta.getCoeficiente();
	}


	
	/**
	 * A este metodo se le pasa el Id de tarjeta y devuelve el listado de cuotas con su percentil disponibles para la tarjeta en cuestion.
	 * 
	 * @param filtro
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/tarjeta/getCuotas", method = RequestMethod.POST)
	public @ResponseBody  List<TarjetaForm> getTipoFacturaCategoriaIva(@RequestBody TarjetaForm filtro) throws ParseException{
		List<TarjetaForm> rta = tarjetaManager.getCuotas( ConvertionUtil.IntValueOf(filtro.getCodigo()));
		return rta;
	}
	
}
