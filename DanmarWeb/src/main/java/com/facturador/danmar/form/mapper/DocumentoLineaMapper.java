package com.facturador.danmar.form.mapper;

import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.form.DocumentoLineaForm;
import com.facturador.danmar.model.DocumentoLinea;


public class DocumentoLineaMapper extends MapperImpl<DocumentoLinea,DocumentoLineaForm>{


	public DocumentoLinea getEntidad(DocumentoLineaForm form) {
		DocumentoLinea ent = new DocumentoLinea();
		if (form != null){		
			ent.setId(form.getId());
			ent.setArticuloId(form.getArticuloId());
			ent.setDescripcion(form.getDescripcion());
			ent.setCantidad(ConvertionUtil.IntValueOf(form.getCantidad()));
			ent.setPrecio(ConvertionUtil.DouValueOf(form.getPrecio()));
			ent.setPrecioTC(ConvertionUtil.DouValueOf(form.getPrecioTC()));
			ent.setDocumentoEncabezadoId((form.getEncabezadoId()));
			
		}
		return ent;
	}

	public DocumentoLineaForm getForm(DocumentoLinea ent) {
		DocumentoLineaForm form =new DocumentoLineaForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setArticuloId(ent.getArticuloId());
			form.setCodigo(ConvertionUtil.StrValueOf(ent.getArticuloId()));
			form.setDescripcion(ent.getDescripcion());
			form.setPrecioTC(ConvertionUtil.StrValueOf(ent.getPrecioTC()));
			form.setPrecio(ConvertionUtil.StrValueOf(ent.getPrecio()));
		}
		return form;
	}


}