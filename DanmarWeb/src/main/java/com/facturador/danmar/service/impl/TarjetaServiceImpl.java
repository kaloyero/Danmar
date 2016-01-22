package com.facturador.danmar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.danmar.dbf.dto.TarjetaDto;
import com.facturador.danmar.config.Configuration;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.dao.TarjetaDao;
import com.facturador.danmar.model.Tarjeta;
import com.facturador.danmar.service.TarjetaService;

@Service("tarjetaService")
public class TarjetaServiceImpl extends GenericServiceImpl<Tarjeta> 
			implements TarjetaService {
	
	private static final String SERVICIO_CONSULTA_TARJETAS_ALICUOTA = "/servicio/getAllTarjetaAlicuota";
	
	@Autowired
	private TarjetaDao tarjetaDao;

	@Override
	protected GenericDao<Tarjeta> getDao() {
		return tarjetaDao;
	}

	@SuppressWarnings("unchecked")
	public List<TarjetaDto> getAllClientesDbf() {
		//Consulto las estadisticas
		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> response = restTemplate.getForEntity("http://192.168.2.103/SAT-TurneroRestApi/servicio/test",String.class);
//		ArticuloDto[] articulos = restTemplate.getForObject(PROTOCOLO+
//												Configuration.getProperty(Configuration.DBF_IP)+
//												PROYECTO+SERVICIO_CONSULTA_ARTICULOS , 
//											ArticuloDto[].class);
		List<TarjetaDto> lista = restTemplate.getForObject(Configuration.PROTOCOLO_DBF_API+
				Configuration.getProperty(Configuration.DBF_IP)+
				Configuration.PROYECTO_DBF_API+SERVICIO_CONSULTA_TARJETAS_ALICUOTA , 
				List.class);

		return lista;
		
	}
}