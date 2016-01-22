package com.danmar.dbf.rest.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.TarjetaDto;
import com.danmar.dbf.rest.ConsultasService;
import com.danmar.dbf.service.ArticuloService;
import com.danmar.dbf.service.ClienteService;
import com.danmar.dbf.service.TarjetaService;
import com.danmar.dbf.service.impl.ArticuloServiceImpl;
import com.danmar.dbf.service.impl.ClienteServiceImpl;
import com.danmar.dbf.service.impl.TarjetaServiceImpl;

/**
 * Servicios
 * 
 * @author Alejandro Masciotra
 *
 */
@RestController
@RequestMapping("/servicio")
public class ConsultasServiceImpl implements ConsultasService{

	@RequestMapping("/getAllArticulos")
	public synchronized List<ArticuloDto> getArticulos() {
		ArticuloService service = new ArticuloServiceImpl();
		
		List<ArticuloDto> articulos = service.getAll();
		
		return articulos;
	}

	@RequestMapping("/getAllCliente")
	public synchronized List<ClienteDto> getClientes() {
		ClienteService service = new ClienteServiceImpl();
		
		List<ClienteDto> clientes = service.getAll();
		
		return clientes;
	}
	
	@RequestMapping("/getAllTarjetaAlicuota")
	public synchronized List<TarjetaDto> getTArjetaAlicuota() {
		TarjetaService service = new TarjetaServiceImpl();
		
		List<TarjetaDto> tarjetas = service.getAll();
		
		return tarjetas;
	}
	
	@RequestMapping("/test")
	public String getTest() {
	
		System.out.println("Servicio de Prueba");
		
		return "Ok";
	}
}