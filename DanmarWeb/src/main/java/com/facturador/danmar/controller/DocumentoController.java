package com.facturador.danmar.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.bean.CategoriaIvaEnum;
import com.facturador.danmar.form.CategoriaIvaForm;
import com.facturador.danmar.form.DocumentoEncabezadoForm;
import com.facturador.danmar.manager.CategoriaIvaManager;
import com.facturador.danmar.manager.DocumentoEncabezadoManager;


@Controller
public class DocumentoController {

	@Autowired
	CategoriaIvaManager categoriaIvaManager;
	
	@Autowired
	DocumentoEncabezadoManager documentoEncabezadoManager;
	

	@RequestMapping(value = "/Documento/save", method = RequestMethod.POST)
	public @ResponseBody  String guardar(@RequestBody DocumentoEncabezadoForm form) throws ParseException{
		
		String rta = documentoEncabezadoManager.saveDoc(form);
		
		return "NroFacturaGenerado";
	}


	@RequestMapping(value = "/documento/getAlicuotaCategoriaIva", method = RequestMethod.POST)
//	public @ResponseBody  String guardar(@ModelAttribute(value = "Form") DocumentoEncabezadoForm form,
//				BindingResult result, HttpServletRequest request) throws ParseException{
	public @ResponseBody  String getAlicuotaCategoriaIva(@RequestBody String categoria) throws ParseException{
		//Convierto el tecto de categoria Iva a numero (codigo)
		String codigoCategoria = CategoriaIvaEnum.getCategoriaIvaByNombre(categoria);
		
		//Consulto por el numero (codigo) de Categoria Iva la alicuota
		CategoriaIvaForm form = categoriaIvaManager.findById(ConvertionUtil.IntValueOf(codigoCategoria));
		
		return form.getAlicuota();
	}

	@RequestMapping(value = "/documento/getTipoFacturaCategoriaIva", method = RequestMethod.POST)
//	public @ResponseBody  String guardar(@ModelAttribute(value = "Form") DocumentoEncabezadoForm form,
//				BindingResult result, HttpServletRequest request) throws ParseException{
	public @ResponseBody  String getTipoFacturaCategoriaIva(@RequestBody String categoria) throws ParseException{
		String tipoFactura = "B";
		CategoriaIvaEnum categoriaObj = CategoriaIvaEnum.getCategoriaIvaObjByNombre(categoria);
		
		if (CategoriaIvaEnum.RESPONSABLE_INSCRIPTO == categoriaObj) {
			tipoFactura = "A";	
		}
		
		return tipoFactura;
	}
	
}
