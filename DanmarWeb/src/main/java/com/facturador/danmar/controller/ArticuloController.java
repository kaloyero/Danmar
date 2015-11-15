package com.facturador.danmar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.danmar.manager.BaseManager;
import com.facturador.danmar.controller.i.IPaginadoController;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.manager.ArticuloManager;
import com.facturador.danmar.model.Articulo;


@Controller
@RequestMapping(value = "/articulo")
public class ArticuloController extends PaginadoController<Articulo,ArticuloForm>
	implements IPaginadoController<ArticuloForm> {

	@Autowired
	ArticuloManager articuloManager;

	@Override
	protected BaseManager getManager() {
		return  articuloManager;
	}

	
}
