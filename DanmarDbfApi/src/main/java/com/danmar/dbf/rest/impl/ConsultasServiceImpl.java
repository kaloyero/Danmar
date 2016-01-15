package com.danmar.dbf.rest.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.rest.ConsultasService;
import com.danmar.dbf.service.ArticuloService;
import com.danmar.dbf.service.impl.ArticuloServiceImpl;

/**
 * Servicios
 * 
 * @author Alejandro Masciotra
 *
 */
public class ConsultasServiceImpl implements ConsultasService{

	public synchronized List<ArticuloDto> getArticulos() {
		ArticuloService service = new ArticuloServiceImpl();
		
		List<ArticuloDto> articulos = service.getAll();
		
		return articulos;
	}

	public synchronized List<ArticuloDto> getClientes() {
		ArticuloService service = new ArticuloServiceImpl();
		
		List<ArticuloDto> articulos = service.getAll();
		
		return articulos;
	}
	
	public synchronized List<ArticuloDto> getTArjetaAlicuota() {
		ArticuloService service = new ArticuloServiceImpl();
		
		List<ArticuloDto> articulos = service.getAll();
		
		return articulos;
	}
	
	public String getTest() {
	
		System.out.println("Servicio de Prueba");
		
		return "Ok";
	}
}