package com.facturador.danmar.form.mapper;

import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.DocumentoImpuestoForm;
import com.facturador.danmar.model.DocumentoImpuesto;


public class DocumentoImpuestoMapper extends MapperImpl<DocumentoImpuesto,DocumentoImpuestoForm>{


	public DocumentoImpuesto getEntidad(DocumentoImpuestoForm form) {
		DocumentoImpuesto ent = new DocumentoImpuesto();
		if (form != null){		
			ent.setId(form.getId());
		}
		return ent;
	}

	public DocumentoImpuestoForm getForm(DocumentoImpuesto ent) {
		DocumentoImpuestoForm form =new DocumentoImpuestoForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setAlicuota(FormatUtil.format2DecimalsStr(ent.getAlicuota()));
			form.setAlicuotaNum(ent.getAlicuota());
			form.setImporte(FormatUtil.format2DecimalsStr(ent.getImporte()));
			
		}
		return form;
	}


}