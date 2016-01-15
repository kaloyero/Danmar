package com.facturador.danmar.form.mapper;


import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.bean.CategoriaIvaEnum;
import com.facturador.danmar.form.ClienteForm;
import com.facturador.danmar.model.Cliente;


public class ClienteMapper extends MapperImpl<Cliente,ClienteForm>{


	public Cliente getEntidad(ClienteForm form) {
		Cliente ent = new Cliente();
		if (form != null){		

			
		}
		return ent;
	}

	public ClienteForm getForm(Cliente ent) {
		ClienteForm cliente=new ClienteForm();
		if (ent != null){
			cliente.setCodigo(ent.getId());
//			cliente.setaCargo(ent.getaCargo());
			cliente.setCategoria(CategoriaIvaEnum.getCategoriaIvaByCodigo(ent.getCategoria()));
//			cliente.setCondicionPago(FormatUtil.format2DecimalsStr(ent.getCondicionPago()));
//			cliente.setContacto(ent.getContacto());
			cliente.setCuit(ent.getCuit());
//			cliente.setDescuento1(FormatUtil.format2DecimalsStr(ent.getDescuento1()));
//			cliente.setDescuento2(FormatUtil.format2DecimalsStr(ent.getDescuento2()));
//			cliente.setDescuento3(FormatUtil.format2DecimalsStr(ent.getDescuento3()));
//			cliente.setDescuento4(FormatUtil.format2DecimalsStr(ent.getDescuento4()));
//			cliente.setDescuento5(FormatUtil.format2DecimalsStr(ent.getDescuento5()));
//			cliente.setDescuento6(FormatUtil.format2DecimalsStr(ent.getDescuento6()));
			cliente.setDireccion(ent.getDireccion());
//			cliente.setDomicilioEntrega(ent.getDomicilioEntrega());
//			cliente.setDomicilioFiscal(ent.getDomicilioFiscal());
//			cliente.setfUltPago(DateUtil.convertDateToString(ent.getfUltPago()));
//			cliente.setHorario(ent.getHorario());
			cliente.setLocalidad(ent.getLocalidad());
			cliente.setNombre(ent.getNombre());
			cliente.setProvincia(ent.getProvincia());
			cliente.setRazonSocial(ent.getRazonSocial());
			cliente.setRetencionIb(FormatUtil.format2DecimalsStr(ent.getRetIIBB()));
			cliente.setSaldo(FormatUtil.format2DecimalsStr(ent.getSaldo()));
			cliente.setSaldoNc(FormatUtil.format2DecimalsStr(ent.getSaldoNC()));
			cliente.setTelefono(ent.getTelefono());
			cliente.setTipo(ConvertionUtil.StrValueOf(ent.getTipoCliente()));
//			cliente.setUltimoPago(FormatUtil.format2DecimalsStr(ent.getUltimoPago()));
//			cliente.setVarios(ent.getVarios());
//			cliente.setVendedor(ConvertionUtil.StrValueOf(ent.getVendedor()));

		}
		return cliente;
	}


}