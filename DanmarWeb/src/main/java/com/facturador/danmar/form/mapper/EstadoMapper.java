package com.facturador.danmar.form.mapper;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.EstadosForm;
import com.facturador.danmar.model.Estados;


public class EstadoMapper extends MapperImpl<Estados,EstadosForm>{


	public Estados getEntidad(EstadosForm form) {
		Estados ent = new Estados();
		if (form != null){		
			ent.setId(form.getId());
			ent.setTarjeta(ConvertionUtil.IntValueOf(form.getTarjeta()));
			ent.setCoeficiente(ConvertionUtil.DouValueOf(form.getCoeficiente()));
			ent.setCuotas(ConvertionUtil.IntValueOf(form.getCuotas()));
			ent.setCuponNro(form.getCuponNro());
			ent.setImporte(ConvertionUtil.DouValueOf(form.getImporte()));
		}
		return ent;
	}

	public EstadosForm getForm(Estados ent) {
		EstadosForm form =new EstadosForm();
		if (ent != null){
			form.setId(ent.getId());
			form.setTarjeta(ConvertionUtil.StrValueOf(ent.getTarjeta()));
			form.setCoeficiente(FormatUtil.format4DecimalsStr(ent.getCoeficiente()));
			form.setCuotas(ConvertionUtil.StrValueOf(ent.getCuotas()));
			form.setCuponNro(ent.getCuponNro());
			form.setImporte(FormatUtil.format4DecimalsStr(ent.getImporte()));
		}
		return form;
	}


}