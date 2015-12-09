package com.facturador.danmar.form.mapper;

import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.CategoriaIvaForm;
import com.facturador.danmar.model.CategoriaIva;


public class CategoriaIvaMapper extends MapperImpl<CategoriaIva,CategoriaIvaForm>{


	public CategoriaIva getEntidad(CategoriaIvaForm form) {
		CategoriaIva ent = new CategoriaIva();
		if (form != null){		
			ent.setCategoria(form.getId());
			
		}
		return ent;
	}

	public CategoriaIvaForm getForm(CategoriaIva ent) {
		CategoriaIvaForm form =new CategoriaIvaForm();
		if (ent != null){
			form.setId(ent.getCategoria());
			form.setNombre(ent.getNombre());
			form.setCategoria(ent.getCategoria());
			form.setAlicuota(FormatUtil.format2DecimalsStr(ent.getAlicuota()));
			form.setAlicuotaNum(ent.getAlicuota());
		}
		return form;
	}


}