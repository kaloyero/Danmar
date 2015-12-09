package com.facturador.danmar.form.mapper;

import com.facturador.danmar.form.PagoTipoForm;
import com.facturador.danmar.model.PagoTipo;


public class PagoTipoMapper extends MapperImpl<PagoTipo,PagoTipoForm>{


	public PagoTipo getEntidad(PagoTipoForm form) {
		PagoTipo ent = new PagoTipo();
		if (form != null){		
			ent.setId(form.getId());
			ent.setCodigo(form.getCodigo());
			ent.setNombre(form.getNombre());
			ent.setDescripcion(form.getDescripcion());	
			
		}
		return ent;
	}

	public PagoTipoForm getForm(PagoTipo ent) {
		PagoTipoForm form =new PagoTipoForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setCodigo(ent.getCodigo());
			form.setNombre(ent.getNombre());
			form.setDescripcion(ent.getDescripcion());	
		}
		return form;
	}


}