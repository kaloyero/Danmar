package com.facturador.danmar.manager.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.mapper.Mapper;
import com.facturador.danmar.form.DocumentoPagoForm;
import com.facturador.danmar.form.mapper.DocumentoPagoMapper;
import com.facturador.danmar.manager.DocumentoPagoManager;
import com.facturador.danmar.model.DocumentoPago;
import com.facturador.danmar.service.DocumentoPagoService;
import com.facturador.danmar.service.GenericService;

@Service("documentoPagoManager")
public class DocumentoPagoManagerImpl extends GenericManagerImpl<DocumentoPagoForm> 
implements DocumentoPagoManager {
	
@Autowired
private DocumentoPagoService DocumentoPagoService;

@Override
protected GenericService<DocumentoPago> getService() {
return DocumentoPagoService;
}
@Override
protected Mapper<DocumentoPago,DocumentoPagoForm> getMapper() {
return new DocumentoPagoMapper();
}




}