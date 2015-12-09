package com.facturador.danmar.form.mapper;

import com.facturador.danmar.form.DocumentoTipoForm;
import com.facturador.danmar.model.DocumentoTipo;


public class DocumentoTipoMapper extends MapperImpl<DocumentoTipo,DocumentoTipoForm>{


	public DocumentoTipo getEntidad(DocumentoTipoForm form) {
		DocumentoTipo ent = new DocumentoTipo();
		if (form != null){		
			ent.setId(form.getId());
			ent.setCodigo(form.getCodigo());
			ent.setNombre(form.getNombre());
			ent.setDescripcion(form.getDescripcion());	
			
		}
		return ent;
	}

	public DocumentoTipoForm getForm(DocumentoTipo ent) {
		DocumentoTipoForm form =new DocumentoTipoForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setCodigo(ent.getCodigo());
			form.setNombre(ent.getNombre());
			form.setDescripcion(ent.getDescripcion());	
		}
		return form;
	}


}