package com.facturador.danmar.form.mapper;

import com.danmar.mapper.Mapper;
import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.form.ArticuloForm;
import com.facturador.danmar.model.Articulo;


public class ArticuloMapper extends MapperImpl<Articulo,ArticuloForm> implements Mapper<Articulo, ArticuloForm>{


	public Articulo getEntidad(ArticuloForm form) {
		Articulo ent = new Articulo();
		if (form != null){		

			
		}
		return ent;
	}

	public ArticuloForm getForm(Articulo ent) {
		ArticuloForm articulo=new ArticuloForm();
		if (ent != null){
			articulo.setCodigo(ConvertionUtil.StrValueOf(ent.getId()));

			articulo.setArticulo(ent.getArticulo());
//        	articulo.setCanMaxima(ConvertionUtil.StrValueOf(ent.getCanMaxima()));
//        	articulo.setCanMinima(ConvertionUtil.StrValueOf(ent.getCanMinima()));
        	articulo.setCc1(ent.getCc1());
        	articulo.setCc2(ent.getCc2());
        	articulo.setCc3(ent.getCc3());
        	articulo.setCc4(ent.getCc4());
        	articulo.setCc5(ent.getCc5());
//        	articulo.setCodigoProv(ent.getCodigoProv());
//        	articulo.setCosto(FormatUtil.format2DecimalsStr(ent.getCosto()));
//        	articulo.setDescuentoAdicional(ent.getDescuentoAdicional());
//        	articulo.setDescuentoProv1(ent.getDescuentoProv1());
//        	articulo.setDescuentoProv2(ent.getDescuentoProv2());
//        	articulo.setDescuentos(ent.getDescuentos());
//        	articulo.setExistentes(ent.getExistentes());
//        	articulo.setFacturaCompra(ConvertionUtil.StrValueOf(ent.getFacturaCompra()));
//        	articulo.setfCamprec(DateUtil.convertDateToString(ent.getfCamprec()));
//        	articulo.setFechaCompra(DateUtil.convertDateToString(ent.getFechaCompra()));
//        	articulo.setfVarmay(ent.getVarMay());
//        	articulo.setfVarmin(ent.getVarMin());
//        	articulo.setGanancia( FormatUtil.format2DecimalsStr(ent.getGanancia()) );
//        	articulo.setGananciaMy(FormatUtil.format2DecimalsStr(ent.getGananciaMy()) );
//        	articulo.setLinea(ent.getLinea());
//        	articulo.setListaPrecioAux(FormatUtil.format2DecimalsStr(ent.getListaPrecioAux()) );
//        	articulo.setManoDeObra(ent.getManoDeObra());
//        	articulo.setMonedaCos(ent.getMonedaCos());
//        	articulo.setOrigen(ent.getOrigen());
        	articulo.setPrecio(FormatUtil.format2DecimalsStr(ent.getPrecio()));
//        	articulo.setPrecioLp(FormatUtil.format2DecimalsStr(ent.getPrecioLp()));
//        	articulo.setPrecioMayorista(FormatUtil.format2DecimalsStr(ent.getPrecioMayorista()));
//        	articulo.setProveedor(ent.getProveedor());
//        	articulo.setRecambio(ent.getRecambio());
//        	articulo.setReservados(ent.getReservados());
//        	articulo.setTiempo(ent.getTiempo());
        	articulo.setTipo(ent.getTipo());
//        	articulo.setVariacion(ent.getVariacion());
//        	articulo.setVarMay(ent.getVarMay());
//        	articulo.setVarMin(ent.getVarMin());
//        	articulo.setVisible(ent.getVisible());

		}
		return articulo;
	}


}