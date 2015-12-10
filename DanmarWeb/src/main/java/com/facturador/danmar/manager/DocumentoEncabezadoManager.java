package com.facturador.danmar.manager;

import com.facturador.danmar.form.DocumentoEncabezadoForm;


public interface DocumentoEncabezadoManager extends GenericManager<DocumentoEncabezadoForm> {

	String saveDoc(DocumentoEncabezadoForm form);

	
}
