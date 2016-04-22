package com.facturador.danmar.form.mapper;

import java.util.ArrayList;
import java.util.List;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.DocumentoLineaForm;
import com.facturador.danmar.model.DocumentoLinea;
import com.facturador.danmar.model.DocumentoLinea_V;


public class DocumentoLineaMapper extends MapperImpl<DocumentoLinea,DocumentoLineaForm>{


	public DocumentoLinea getEntidad(DocumentoLineaForm form) {
		DocumentoLinea ent = new DocumentoLinea();
		if (form != null){		
			ent.setId(form.getId());
			ent.setArticuloId(form.getArticuloId());
			ent.setDescripcion(form.getDescripcion());
			//ent.setCantidad(ConvertionUtil.IntValueOf(form.getCantidad()));
			ent.setCantidad(ConvertionUtil.DouValueOf(form.getCantidad()));
			ent.setPrecio(ConvertionUtil.DouValueOf(form.getPrecio()));
			ent.setPrecioFinal(ConvertionUtil.DouValueOf(form.getPrecioFinal()));
			ent.setDocumentoEncabezadoId((form.getEncabezadoId()));
//			if (form.getImpuestos() != null){
//				ent.setImpuestos(new HashSet<DocumentoImpuesto>());
//				DocumentoImpuestoMapper mapper = new DocumentoImpuestoMapper();
//				for (DocumentoImpuestoForm imp : form.getImpuestos() ) {
//					ent.getImpuestos().add(mapper.getEntidad(imp));
//				}
//			}
			
			
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
			form.setPrecioFinal(FormatUtil.format2DecimalsStr(ent.getPrecioFinal()));
			form.setPrecio(FormatUtil.format2DecimalsStr(ent.getPrecio()));
			
		}
		return form;
	}

	public DocumentoLineaForm getForm(DocumentoLinea_V ent) {
		DocumentoLineaForm form =new DocumentoLineaForm();
		if (ent != null){
			form.setEncabezadoId(ent.getDocumentoEncabezadoId());
			form.setArticuloId(ent.getArticuloId());
			form.setArticulo(ent.getArticulo());
			form.setCantidad(ConvertionUtil.StrValueOf(ent.getCantidad()));
			form.setPrecioFinal(FormatUtil.format2DecimalsStr(ent.getPrecioFinal()));
			form.setCc1(ent.getCc1());
			form.setCc2(ent.getCc2());
			form.setCc3(ent.getCc3());
			form.setCc4(ent.getCc4());
			form.setCc5(ent.getCc5());
			form.setPrecio(FormatUtil.format2DecimalsStr(ent.getPrecio()));
//			form.setPrecioUnitario(FormatUtil.format2DecimalsStr(ent.getPrecioUnitario()));
			form.setCodigo(ConvertionUtil.StrValueOf(ent.getArticuloId()));
			form.setTotalArticulos(FormatUtil.format2DecimalsStr(ent.getTotalArticulos()));
			form.setTotalLinea(FormatUtil.format2DecimalsStr(ent.getTotalLinea()));
			form.setTotalImpuestos(FormatUtil.format2DecimalsStr(ent.getTotalImpuestos()));
		}
		return form;
	}
	
	public List<DocumentoLineaForm> getFormListView(List<DocumentoLinea_V> list) {
		List<DocumentoLineaForm> formList = new ArrayList<DocumentoLineaForm>();
		
		for (DocumentoLinea_V ent : list) {
			formList.add((DocumentoLineaForm)getForm(ent));
		}
	
		return formList;
	}
}