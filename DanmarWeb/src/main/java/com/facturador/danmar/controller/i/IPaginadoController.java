package com.facturador.danmar.controller.i;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.filtro.Paginacion;

public interface IPaginadoController<E> {

	
	@RequestMapping(value = "/findAll/", method = RequestMethod.POST)
	public @ResponseBody	List<E> findAll(@RequestBody Paginacion pagina) ;
	
	@RequestMapping(value = "/searchByField/", method = RequestMethod.POST)
	public @ResponseBody List<E> searchByField(@RequestBody Paginacion pagina) ;

//	@RequestMapping(value = "/searchByFiltro/", method = RequestMethod.POST)
//	public @ResponseBody List<E> searchByFiltro(@RequestBody F pagina) ;

	
}
