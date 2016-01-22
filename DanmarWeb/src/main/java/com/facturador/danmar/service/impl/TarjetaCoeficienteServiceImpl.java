package com.facturador.danmar.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.danmar.dbf.dto.TarjetaDto;
import com.facturador.danmar.config.Configuration;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.dao.TarjetaCoeficienteDao;
import com.facturador.danmar.model.TarjetaCoeficiente;
import com.facturador.danmar.model.TarjetaCuotaGroupId;
import com.facturador.danmar.service.TarjetaCoeficienteService;

@Service("tarjetaCoeficienteService")
public class TarjetaCoeficienteServiceImpl extends GenericServiceImpl<TarjetaCoeficiente> 
			implements TarjetaCoeficienteService {
	
	private static final String SERVICIO_CONSULTA_TARJETA_ALICUOTA = "/servicio/getAllTarjetaAlicuota";
	
	@Autowired
	private TarjetaCoeficienteDao tarjetaCoeficienteDao;

	@Override
	protected GenericDao<TarjetaCoeficiente> getDao() {
		return tarjetaCoeficienteDao;
	}

	public List<TarjetaCoeficiente> getAll() {
		return tarjetaCoeficienteDao.getAll();
	}   

	public List<TarjetaCoeficiente> getCuotasByTarjeta(int tarjeta) {
		return tarjetaCoeficienteDao.getAllByTarjeta(tarjeta);
	}   

	
	public TarjetaCoeficiente getById(int tarjeta,int cuotas) {
		TarjetaCoeficiente dto = tarjetaCoeficienteDao.getById(tarjeta, cuotas);
		return dto;
	}	
	
	@Override
	public TarjetaDto[] getAllTarjetaCoefDbf() {
		RestTemplate restTemplate = new RestTemplate();
		//Consulto al servicio DBF por los clientes
		TarjetaDto[] array = restTemplate.getForObject(Configuration.PROTOCOLO_DBF_API+
				Configuration.getProperty(Configuration.DBF_IP)+
				Configuration.PROYECTO_DBF_API+SERVICIO_CONSULTA_TARJETA_ALICUOTA , 
				TarjetaDto[].class);

		return array;
		
	}
	
	@Override
	public List<TarjetaCoeficiente> mapperDtoToModel(TarjetaDto[] tarjetaDbf){

		//los guardo en un array
		List<TarjetaCoeficiente> lista = new ArrayList<TarjetaCoeficiente>();
		for (TarjetaDto dto : tarjetaDbf) {
			TarjetaCoeficiente ent  =returnModelByDto(dto);
			lista.add(ent);
		}

		return lista;
	}
	
	protected TarjetaCoeficiente returnModelByDto( TarjetaDto dto){
		TarjetaCoeficiente ent  =new TarjetaCoeficiente();
		ent.setTarjetaCuota(new TarjetaCuotaGroupId());
		ent.getTarjetaCuota().setTarjetaId(dto.getCodigo());
		ent.getTarjetaCuota().setCuotas(dto.getCuotas());
		ent.setCoeficiente(dto.getCoeficiente());

		return ent;
	}
	
	@Override
	public void insertList(List<TarjetaCoeficiente> tarjetaCoef){
		for (TarjetaCoeficiente ent : tarjetaCoef) {
			try { 
				tarjetaCoeficienteDao.saveOrUpdate(ent);
			} catch (Exception e){
				System.out.println("Error insertando tarjeta Alicuota Id: " +  
						ent.getTarjetaCuota().getTarjetaId() + " - " + ent.getTarjetaCuota().getTarjetaId());
			}
		}
	}

}