package com.facturador.danmar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facturador.danmar.form.CategoriaIvaForm;
import com.facturador.danmar.form.DocumentoPagoForm;
import com.facturador.danmar.form.DocumentoTipoForm;
import com.facturador.danmar.form.EstadosForm;
import com.facturador.danmar.form.PagoTipoForm;
import com.facturador.danmar.manager.CategoriaIvaManager;
import com.facturador.danmar.manager.DocumentoPagoManager;
import com.facturador.danmar.manager.DocumentoTipoManager;
import com.facturador.danmar.manager.EstadoManager;
import com.facturador.danmar.manager.PagoTipoManager;


@Controller
//@RequestMapping(value = "/articulo")
public class ConsultasController  {

	@Autowired
	DocumentoPagoManager documentoPagoManager;

	@Autowired
	DocumentoTipoManager documentoTipoManager;
	
	@Autowired
	CategoriaIvaManager categoriaIvaManager;
	
	@Autowired
	PagoTipoManager pagoTipoManager;

	
	@Autowired
	EstadoManager estadoManager;
	
	@RequestMapping(value = "/documentoPago/getAll/{orden}", method = RequestMethod.GET)
	public @ResponseBody	List<DocumentoPagoForm> findAllDocumentoaPago(@PathVariable Integer orden){
		return documentoPagoManager.getAll();
	}	

	@RequestMapping(value = "/documentoTipo/getAll/{orden}", method = RequestMethod.GET)
	public @ResponseBody	List<DocumentoTipoForm> findAllDocumentoaTipo(@PathVariable Integer orden){
		return documentoTipoManager.getAll();
	}	

	@RequestMapping(value = "/categoriaIva/getAll/{orden}", method = RequestMethod.GET)
	public @ResponseBody	List<CategoriaIvaForm> findAllcategoriaIva(@PathVariable Integer orden){
		return categoriaIvaManager.getAll();
	}	

	@RequestMapping(value = "/estados/getAll/{orden}", method = RequestMethod.GET)
	public @ResponseBody	List<EstadosForm> findAllEstados(@PathVariable Integer orden){
		return estadoManager.getAll();
	}	
	
	@RequestMapping(value = "/pagoTipo/getAll/{orden}", method = RequestMethod.GET)
	public @ResponseBody	List<PagoTipoForm> findAllPagoTipo(@PathVariable Integer orden){
		return pagoTipoManager.getAll();
	}	
	
}
