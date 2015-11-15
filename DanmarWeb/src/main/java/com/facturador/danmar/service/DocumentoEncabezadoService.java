package com.facturador.danmar.service;

import com.danmar.error.ErrorRespuestaBean;
import com.facturador.danmar.model.DocumentoEncabezado;


public interface DocumentoEncabezadoService  {

	ErrorRespuestaBean save(DocumentoEncabezado dto);
}
