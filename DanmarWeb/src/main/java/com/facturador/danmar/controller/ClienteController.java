package com.facturador.danmar.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.form.PaginadoForm;
import com.facturador.danmar.manager.ClienteManager;
import com.facturador.danmar.manager.EstadoManager;


@Controller
@RequestMapping(value = "/cliente")
public class ClienteController  {

	@Autowired
	ClienteManager clienteManager;
	
	@Autowired
	EstadoManager estadoManager;
	
	@RequestMapping("/Probando")
	public ModelAndView getVersion(){

		return new ModelAndView("version");
	}

	@RequestMapping(value = "/findAll/", method = RequestMethod.POST)
	public @ResponseBody	List<ClienteForm> findAll(@RequestBody FiltroCliente filtro){
		return clienteManager.getAll(filtro); 
		
	}
	
	@RequestMapping(value = "/searchByFiltros", method = RequestMethod.POST)
	public @ResponseBody PaginadoForm<ClienteForm> searchArticulosByFiltro(@RequestBody FiltroCliente filtro) throws ParseException{
		PaginadoForm<ClienteForm> listado = new PaginadoForm<ClienteForm>();
		listado.setLista(clienteManager.getAll(filtro));
		listado.setTamanio(clienteManager.getAllCount(filtro));
		return listado; 
		
	}

	@RequestMapping(value = "/getById/{codigo}", method = RequestMethod.GET)
	public @ResponseBody ClienteForm getClienteById(@PathVariable Integer codigo) {
		return clienteManager.getById(codigo);
	}

	@RequestMapping(value = "/updateClientesDBF", method = RequestMethod.GET)
	public @ResponseBody String updateClientes() {
		clienteManager.updateClientesDBF();
		return "OK";
	}

}
