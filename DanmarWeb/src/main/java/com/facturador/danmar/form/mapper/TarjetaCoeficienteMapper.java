package com.facturador.danmar.form.mapper;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.TarjetaForm;
import com.facturador.danmar.model.TarjetaCoeficiente;


public class TarjetaCoeficienteMapper extends MapperImpl<TarjetaCoeficiente,TarjetaForm>{


	public TarjetaCoeficiente getEntidad(TarjetaForm form) {
		TarjetaCoeficiente ent = new TarjetaCoeficiente();
		if (form != null){		

			
		}
		return ent;
	}

	public TarjetaForm getForm(TarjetaCoeficiente ent) {
		TarjetaForm tarjeta=new TarjetaForm();
		if (ent != null){
			tarjeta.setTarjetaId( ConvertionUtil.StrValueOf(ent.getTarjetaCuota().getTarjetaId()));
        	tarjeta.setCuotas( ConvertionUtil.StrValueOf(ent.getTarjetaCuota().getCuotas()));
        	tarjeta.setCoeficiente(FormatUtil.format2DecimalsStr(ent.getCoeficiente()));

		}
		return tarjeta;
	}


}