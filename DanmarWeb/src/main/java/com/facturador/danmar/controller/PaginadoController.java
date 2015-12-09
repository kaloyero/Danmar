package com.facturador.danmar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danmar.filtro.Paginacion;
import com.danmar.manager.BaseManager;
import com.danmar.service.BaseService;
import com.facturador.danmar.manager.impl.BaseManagerImpl;

public abstract class PaginadoController<E,F> implements BaseService {
	
	protected abstract BaseManager getManager();

	
	@RequestMapping("/Probando2")
	public ModelAndView getVersion(){
		Paginacion pag = new Paginacion();
		pag.setCantRegistros(5);
		pag.setPagina(5);
		
		 ((BaseManagerImpl<E, F>) getManager()).getAll(pag);

		return new ModelAndView("version");
	}
	
	@RequestMapping(value = "/test/", method = RequestMethod.GET)
	public @ResponseBody List<F> findAll() {
		Paginacion pag = new Paginacion();
		pag.setCantRegistros(5);
		pag.setPagina(5);
		
		return ((BaseManagerImpl<E, F>) getManager()).getAll(pag);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/findAll/", method = RequestMethod.GET)
	public @ResponseBody List<F> findAll(@RequestBody Paginacion paginacion) {
		return ((BaseManagerImpl<E, F>) getManager()).getAll(paginacion);
	}

	@RequestMapping(value = "/searchByField/", method = RequestMethod.POST)
	public @ResponseBody List<F> searchByField(@RequestBody Paginacion paginacion) {
		return null;
	}

//	@RequestMapping(value = "/searchByFiltro/", method = RequestMethod.POST)
//	public List<E> searchByFiltro(@RequestBody  F filtroPaginacion) {
//		return null;
//	}

}
