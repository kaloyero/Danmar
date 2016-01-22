package com.facturador.danmar.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.error.ErrorRespuestaBean;
import com.danmar.filtro.Paginacion;
import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.config.Configuration;
import com.facturador.danmar.dao.ArticuloDao;
import com.facturador.danmar.model.Articulo;
import com.facturador.danmar.service.ArticuloService;

@Service("articuloService")
public class ArticuloServiceImpl implements ArticuloService {


	private static final String SERVICIO_CONSULTA_ARTICULOS = "/servicio/getAllArticulos";
	
	
	@Autowired
	private ArticuloDao articuloDao;

	@Transactional(readOnly=true)
	public ErrorRespuestaBean save(Articulo dto) {
		articuloDao.save(dto);
		return new ErrorRespuestaBean(true);
	}

	@Override
	public List<Articulo> getAll(Paginacion paginacion) {
		return articuloDao.getAllPaging(paginacion);
	}

	public List<Articulo> getAllFilter(FiltroArticulo filtro) {
		return articuloDao.getAllFilterPaging(filtro);
	}
	
	@SuppressWarnings("unchecked")
	public ArticuloDto[] getAllArticulosDbf() {
		RestTemplate restTemplate = new RestTemplate();
		boolean exitSuccess = false;
		ArticuloDto[] array = null; 
		do {
			try{
				//Consulto al servicio DBF por los clientes
				array = restTemplate.getForObject(Configuration.PROTOCOLO_DBF_API+
						Configuration.getProperty(Configuration.DBF_IP)+
						Configuration.PROYECTO_DBF_API+SERVICIO_CONSULTA_ARTICULOS , 
						ArticuloDto[].class);
				exitSuccess = true;
			} catch (Exception e) {
				System.out.println("TimeOut: se llama nuevamente al servicio");
			}
		} while (exitSuccess == false);
		return array;		
		
	}
	
	@Override
	public List<Articulo> mapperDtoToModel(ArticuloDto[] articulosDbf){

		//los guardo en un array
		List<Articulo> lista = new ArrayList<Articulo>();
		for (ArticuloDto dto : articulosDbf) {
			Articulo ent  =returnModelByDto(dto);
			lista.add(ent);
		}

		return lista;
	}
	protected Articulo returnModelByDto( ArticuloDto dto){
		Articulo ent  =new Articulo();
		String id = dto.getCc1().trim() + "101" + 
					dto.getCc2().trim() + "202-" + 
					dto.getCc3().trim() + "303-" + 
					dto.getCc4().trim() + "404-" + 
					dto.getCc5().trim(); 
		
		ent.setId(ConvertionUtil.IntValueOf(id));
		ent.setArticulo(dto.getArticulo());
		ent.setCc1(dto.getCc1());
		ent.setCc2(dto.getCc2());
		ent.setCc3(dto.getCc3());
		ent.setCc4(dto.getCc4());
		ent.setCc5(dto.getCc5());
		ent.setPrecio(dto.getPrecio());
		ent.setTipo(dto.getTipo());

		return ent;
	}
	
	@Override
	public void insertList(List<Articulo> articulosDbf){
		for (Articulo ent : articulosDbf) {
			try { 
				articuloDao.saveOrUpdate(ent);
			} catch (Exception e){
				System.out.println("Error insertando Articulo Id: " + ent.getId());
			}
		}
	}
	

	
}