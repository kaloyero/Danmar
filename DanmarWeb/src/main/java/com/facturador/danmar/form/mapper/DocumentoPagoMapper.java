package com.facturador.danmar.form.mapper;

import com.facturador.danmar.form.DocumentoPagoForm;
import com.facturador.danmar.model.DocumentoPago;


public class DocumentoPagoMapper extends MapperImpl<DocumentoPago,DocumentoPagoForm>{


	public DocumentoPago getEntidad(DocumentoPagoForm form) {
		DocumentoPago ent = new DocumentoPago();
		if (form != null){		
//			ent.setId(form.getId());
//			ent.set
//			
//			
//			ent.setCodigo(form.getCodigo());
//			ent.setNombre(form.getNombre());
//			ent.setDescripcion(form.getDescripcion());		
		}
		return ent;
	}

	public DocumentoPagoForm getForm(DocumentoPago ent) {
		DocumentoPagoForm form =new DocumentoPagoForm();
		if (ent != null){
//			form.setId(ent.getId());
//			form.setCodigo(ent.getCodigo());
//			form.setNombre(ent.getNombre());
//			form.setDescripcion(ent.getDescripcion());			
		}
		return form;
	}


}