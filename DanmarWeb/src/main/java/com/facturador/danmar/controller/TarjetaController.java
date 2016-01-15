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
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.manager.TarjetaCoeficienteManager;
import com.facturador.danmar.manager.TarjetaManager;


@Controller
public class TarjetaController {

	@Autowired
	TarjetaCoeficienteManager tarjetaCoeficienteManager;

	@Autowired
	TarjetaManager tarjetaManager;

	
	@RequestMapping(value = "/tarjeta/getTarjetas", method = RequestMethod.POST)
	public @ResponseBody  List<TarjetaForm> getTarjetas() throws ParseException{
		List<TarjetaForm> rta = tarjetaManager.getAll();
		return rta;
	}
	
	
	@RequestMapping(value = "/tarjeta/getAlicuota", method = RequestMethod.POST)
	public @ResponseBody  String getAlicuotaCategoriaIva(@RequestBody TarjetaForm filtro) throws ParseException{
		
		TarjetaForm rta = tarjetaCoeficienteManager.getById( ConvertionUtil.IntValueOf(filtro.getCodigo().replace("\"", "")), ConvertionUtil.IntValueOf(filtro.getCuotas()));
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
	public @ResponseBody  List<TarjetaForm> getTipoFacturaCategoriaIva(@RequestBody  TarjetaForm filtro) throws ParseException{
		List<TarjetaForm> rta = tarjetaCoeficienteManager.getCuotas( ConvertionUtil.IntValueOf(filtro.getCodigo()));
		for (TarjetaForm form : rta) {
//			Double interes = ((ConvertionUtil.DouValueOf(form.getCoeficiente()) * ConvertionUtil.DouValueOf(filtro.getMonto()) )  ) ;
//			Double importeFinal = ConvertionUtil.DouValueOf(filtro.getMonto()) + interes;
			Double importeFinal = ((ConvertionUtil.DouValueOf(form.getCoeficiente()) * ConvertionUtil.DouValueOf(filtro.getMonto()) )  ) ;
			Double importeCuota = importeFinal / Integer.parseInt(form.getCuotas());
			
			String descripcion = form.getCuotas() + " cuota(s) de $ " + FormatUtil.format2DecimalsStr(importeCuota) + " ( "+form.getCoeficiente()+"% - $ "+FormatUtil.format2DecimalsStr(importeFinal)+") " ;
			
			form.setDescripcion(descripcion);
			form.setMonto(FormatUtil.format2DecimalsStr(importeFinal));

		}
		
		return rta;
	}
	
}
