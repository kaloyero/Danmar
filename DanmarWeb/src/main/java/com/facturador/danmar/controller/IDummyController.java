package com.facturador.danmar.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.danmar.filtro.Paginacion;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.ClienteForm;

public interface IDummyController {

	@RequestMapping(value = "/cliente/findAll/{pagina}/{cantRegistros}", method = RequestMethod.POST)
	public @ResponseBody	List<ClienteForm> findAllClientes(@RequestBody Integer pagina) ;
	
	@RequestMapping(value = "/cliente/searchByField/{filtro}/{pagina}/{cantRegistros}", method = RequestMethod.POST)
	public @ResponseBody List<ClienteForm> searchClientesByField(@RequestBody Paginacion pagina) ;

	@RequestMapping(value = "/cliente/searchByFiltro/{filtro}/{pagina}/{cantRegistros}", method = RequestMethod.POST)
	public @ResponseBody List<ClienteForm> searchClientesByFiltro(@RequestBody FiltroCliente pagina) ;
	
//	@RequestMapping(value = "/cliente/getById/{codigo}", method = RequestMethod.GET)
//	public @ResponseBody ClienteForm getClienteById(@PathVariable Integer codigo);
	
//	@RequestMapping(value = "/articulo/findAll/{pagina}/{cantRegistros}", method = RequestMethod.GET)
//	public @ResponseBody	List<ArticuloForm> findAllArticulos(@PathVariable Integer pagina,@PathVariable Integer cantRegistros);
//	
	@RequestMapping(value = "/articulo/searchByFiltro/", method = RequestMethod.POST)
	public @ResponseBody List<ArticuloForm> searchArticulosByFiltro(@RequestBody  String nombre,@RequestBody  Paginacion pagina);



	@RequestMapping(value = "/articulo/getById/{nombre}", method = RequestMethod.GET)
	public @ResponseBody ArticuloForm getArticuloById(@PathVariable String nombre) ;
	
}
