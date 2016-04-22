package com.facturador.danmar.form.mapper;

import java.util.ArrayList;
import java.util.List;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.DateUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.bean.CategoriaIvaEnum;
import com.facturador.danmar.form.DocumentoEncabezadoForm;
import com.facturador.danmar.model.DocumentoEncabezado;
import com.facturador.danmar.model.DocumentoEncabezado_V;


public class DocumentoEncabezadoMapper extends MapperImpl<DocumentoEncabezado,DocumentoEncabezadoForm>{


	public DocumentoEncabezado getEntidad(DocumentoEncabezadoForm form) {
		DocumentoEncabezado ent = new DocumentoEncabezado();
		if (form != null){		
			ent.setClienteNro(ConvertionUtil.IntValueOf(form.getClienteNro()));
			ent.setDescripcion(form.getDescripcion());
			ent.setEstadoId(ConvertionUtil.IntValueOf(form.getEstadoId()));
			ent.setFecha(DateUtil.convertStringToDate(form.getFecha()));
			ent.setFechaActualiza(DateUtil.convertStringToDate(form.getFechaActualiza()));
			ent.setFechaCreacion(DateUtil.convertStringToDate(form.getFechaCreacion()));
			ent.setId(form.getId());
			ent.setLetra(form.getLetra());
			ent.setNumero(ConvertionUtil.IntValueOf(form.getNumero()));
			ent.setSucursalId(ConvertionUtil.IntValueOf(form.getSucursalId()));
			ent.setTipoDocumentoId(ConvertionUtil.IntValueOf(form.getTipoDocumentoId()));
			ent.setUsuarioActualizaId(ConvertionUtil.IntValueOf(form.getUsuarioActualizaId()));
			ent.setUsuarioCreadorId(ConvertionUtil.IntValueOf(form.getUsuarioCreadorId()));
			
		}
		return ent;
	}

	public DocumentoEncabezadoForm getForm(DocumentoEncabezado ent) {
		DocumentoEncabezadoForm form=new DocumentoEncabezadoForm();
		if (ent != null){
			form.setClienteNro(ConvertionUtil.StrValueOf(ent.getClienteNro()));
			form.setDescripcion(ent.getDescripcion());
			form.setEstadoId(ConvertionUtil.StrValueOf(ent.getEstadoId()));
			form.setFecha(DateUtil.convertDateToString(ent.getFecha()));
			form.setFechaActualiza(DateUtil.convertDateToString(ent.getFechaActualiza()));
			form.setFechaCreacion(DateUtil.convertDateToString(ent.getFechaCreacion()));
			form.setId(ent.getId());
			form.setLetra(ent.getLetra());
			form.setNumero(ConvertionUtil.StrValueOf(ent.getNumero()));
			form.setSucursalId(ConvertionUtil.StrValueOf(ent.getSucursalId()));
			form.setTipoDocumentoId(ConvertionUtil.StrValueOf(ent.getTipoDocumentoId()));
			form.setUsuarioActualizaId(ConvertionUtil.StrValueOf(ent.getUsuarioActualizaId()));
			form.setUsuarioCreadorId(ConvertionUtil.StrValueOf(ent.getUsuarioCreadorId()));
			
		}
		return form;
	}

	public DocumentoEncabezadoForm getFormView(DocumentoEncabezado_V ent) {
		DocumentoEncabezadoForm form=new DocumentoEncabezadoForm();
		if (ent != null){
			form.setClienteNro(ConvertionUtil.StrValueOf(ent.getClienteNro()));
			form.setDescripcion(ent.getDescripcion());
			form.setEstadoCodigo(ent.getEstadoCodigo());
			form.setEstadoNombre(ent.getEstadoNombre());
			form.setFecha(DateUtil.convertDateToString(ent.getFecha()));
//			form.setFechaActualiza(DateUtil.convertDateToString(ent.getFechaActualiza()));
//			form.setFechaCreacion(DateUtil.convertDateToString(ent.getFechaCreacion()));
			form.setId(ent.getId());
			form.setLetra(ent.getLetra());
			form.setNumero(ent.getFacturaNumero());
			form.setTipoDocumentoCodigo(ent.getTipoDocumentoCodigo());
			form.setTipoDocumentoNombre(ent.getTipoDocumentoNombre());
			form.setTotalArticulos(FormatUtil.format2DecimalsStr(ent.getTotalArticulos()));
			form.setTotalDocumento(FormatUtil.format2DecimalsStr(ent.getTotalDocumento()));
			form.setTotalImpuestos(FormatUtil.format2DecimalsStr(ent.getTotalImpuestos()));
			form.setClienteNro(ConvertionUtil.StrValueOf(ent.getClienteNro()));
			form.setClienteCuit(ent.getClienteCuit());
			form.setClienteNombre(ent.getClienteRazonSocial());
			form.setClienteCategoria(ConvertionUtil.StrValueOf(ent.getClienteCategoria()));
			form.setClienteCategoriaNombre(CategoriaIvaEnum.getCategoriaIvaByCodigo(ent.getClienteCategoria()));
//			form.setUsuarioActualizaId(ConvertionUtil.StrValueOf(ent.getUsuarioActualizaId()));
			form.setNombreConsumidorFinal(ent.getNombreConsumidorFinal());
			form.setDocumentoConsumidorFinal(ent.getDocumentoConsumidorFinal());

//			form.setUsuarioCreadorId(ConvertionUtil.StrValueOf(ent.getUsuarioCreadorId()));
			
		}
		return form;
	}
	
	public List<DocumentoEncabezadoForm> getFormViewList(List<DocumentoEncabezado_V> list) {
		List<DocumentoEncabezadoForm> formList = new ArrayList<DocumentoEncabezadoForm>();
		
		for (DocumentoEncabezado_V ent : list) {
			formList.add((DocumentoEncabezadoForm)getFormView(ent));
		}
	
		return formList;
	}
}