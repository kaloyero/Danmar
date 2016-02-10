package com.facturador.danmar.form.mapper;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.model.Tarjeta;


public class TarjetaMapper extends MapperImpl<Tarjeta,TarjetaForm>{


	public Tarjeta getEntidad(TarjetaForm form) {
		Tarjeta ent = new Tarjeta();
		if (form != null){		

			
		}
		return ent;
	}

	public TarjetaForm getForm(Tarjeta ent) {
		TarjetaForm tarjeta=new TarjetaForm();
		if (ent != null){
        	tarjeta.setNombre(ent.getNombre());
        	tarjeta.setCodigo(ConvertionUtil.StrValueOf(ent.getId()));
        	tarjeta.setRecargo(FormatUtil.format4DecimalsStr(ent.getRecargo()));
		}
		return tarjeta;
	}



}