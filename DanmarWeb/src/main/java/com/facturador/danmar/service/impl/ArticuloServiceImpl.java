package com.facturador.danmar.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.error.ErrorRespuestaBean;
import com.danmar.filtro.Paginacion;
import com.facturador.danmar.dao.ArticuloDao;
import com.facturador.danmar.model.Articulo;
import com.facturador.danmar.service.ArticuloService;

@Service("articuloService")
public class ArticuloServiceImpl implements ArticuloService {

	
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

	
}