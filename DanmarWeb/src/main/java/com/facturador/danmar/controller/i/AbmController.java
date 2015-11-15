package com.facturador.danmar.controller.i;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.filtro.Paginacion;
import com.facturador.danmar.form.Form;

public interface AbmController {

	
	@RequestMapping(value = "/findAll/", method = RequestMethod.POST)
	public @ResponseBody	List<Form> findAll(@RequestBody Paginacion pagina) ;
	
	@RequestMapping(value = "/searchByField/", method = RequestMethod.POST)
	public @ResponseBody List<Form> searchByField(@RequestBody Paginacion pagina) ;

	@RequestMapping(value = "/searchByFiltro/", method = RequestMethod.POST)
	public @ResponseBody List<Form> searchByFiltro(@RequestBody Paginacion pagina) ;
	
}
