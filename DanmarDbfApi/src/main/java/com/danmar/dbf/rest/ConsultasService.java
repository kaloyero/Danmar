package com.danmar.dbf.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danmar.dbf.dto.ArticuloDto;

/**
 * Servicios
 * 
 * @author Alejandro Masciotra
 *
 */
@RestController
@RequestMapping("/servicio")
public interface ConsultasService {

	@RequestMapping("/getAllArticulos")
	public List<ArticuloDto> getArticulos();

	@RequestMapping("/getAllArticulos")
	public List<ArticuloDto> getClientes();
	
	@RequestMapping("/getAllArticulos")
	public List<ArticuloDto> getTArjetaAlicuota();
	
	/**
	 * Servicio de prueba
	 * 
	 * @return mensaje de prueba
	 */
	@RequestMapping("/test")
	public String getTest();
}