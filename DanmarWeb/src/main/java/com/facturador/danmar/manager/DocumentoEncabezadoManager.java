package com.facturador.danmar.manager;

import com.danmar.error.ErrorRespuestaBean;
import com.facturador.danmar.form.DocumentoEncabezadoForm;


public interface DocumentoEncabezadoManager  {

	ErrorRespuestaBean save(DocumentoEncabezadoForm form);
}
