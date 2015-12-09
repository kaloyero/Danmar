package com.facturador.danmar.manager.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.DocumentoTipoForm;
import com.facturador.danmar.form.mapper.DocumentoTipoMapper;
import com.facturador.danmar.manager.DocumentoTipoManager;
import com.facturador.danmar.model.DocumentoTipo;
import com.facturador.danmar.service.DocumentoTipoService;
import com.facturador.danmar.service.GenericService;

@Service("documentoTipoManager")
public class DocumentoTipoManagerImpl extends GenericManagerImpl<DocumentoTipoForm> 
implements DocumentoTipoManager {
	
@Autowired
private DocumentoTipoService DocumentoTipoService;

@Override
protected GenericService<DocumentoTipo> getService() {
return DocumentoTipoService;
}
@Override
protected Mapper<DocumentoTipo,DocumentoTipoForm> getMapper() {
return new DocumentoTipoMapper();
}




}