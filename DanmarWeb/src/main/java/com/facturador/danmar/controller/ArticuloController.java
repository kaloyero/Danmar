package com.facturador.danmar.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.PaginadoForm;
import com.facturador.danmar.manager.ArticuloManager;


@Controller
@RequestMapping(value = "/articulo")
public class ArticuloController  {

	@Autowired
	ArticuloManager articuloManager;
	
	
	@RequestMapping("/Probando")
	public ModelAndView getVersion(){
		FiltroArticulo pag = new FiltroArticulo();
		pag.setCantRegistros(5);
		pag.setPagina(5);
		
		articuloManager.getAll(pag);
		
		return new ModelAndView("version");
	}

	
	@RequestMapping(value = "/findAll/", method = RequestMethod.POST)
	public @ResponseBody	List<ArticuloForm> findAll(@RequestBody FiltroArticulo filtro){

		return articuloManager.getAll(filtro); 
		
	}
	
	@RequestMapping(value = "/searchByFiltros", method = RequestMethod.POST)
	public @ResponseBody PaginadoForm<ArticuloForm> searchArticulosByFiltro(@RequestBody FiltroArticulo filtro) throws ParseException{
		PaginadoForm<ArticuloForm> listado = new PaginadoForm<ArticuloForm>();
		listado.setLista(articuloManager.getAll(filtro));
		listado.setTamanio(articuloManager.getAllCount(filtro));
		return listado; 
	}
	
	@RequestMapping(value = "/updateArticulosDBF", method = RequestMethod.GET)
	public @ResponseBody String updateArticulosDBF() {
		articuloManager.updateArticuloDBF();
		return "OK";
	}
}
