package com.facturador.danmar.manager.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;
import com.facturador.danmar.bean.CategoriaIvaEnum;
import com.facturador.danmar.bean.TipoPagoEnum;
import com.facturador.danmar.filtro.FiltroFactura;
import com.facturador.danmar.form.DocumentoEncabezadoForm;
import com.facturador.danmar.form.DocumentoLineaForm;
import com.facturador.danmar.form.mapper.DocumentoEncabezadoMapper;
import com.facturador.danmar.form.mapper.DocumentoLineaMapper;
import com.facturador.danmar.form.mapper.DocumentoPagoMapper;
import com.facturador.danmar.manager.DocumentoManager;
import com.facturador.danmar.model.DocumentoPago;
import com.facturador.danmar.model.Tarjeta;
import com.facturador.danmar.service.ClienteService;
import com.facturador.danmar.service.DocumentoEncabezadoService;
import com.facturador.danmar.service.DocumentoLineaService;
import com.facturador.danmar.service.DocumentoPagoService;
import com.facturador.danmar.service.TarjetaService;
import com.facturador.danmar.util.CalculosUtil;

@Service("documentoManager")
public class DocumentoManagerImpl implements DocumentoManager {

	@Autowired
	private DocumentoEncabezadoService documentoEncabezadoService;

	@Autowired
	private DocumentoLineaService documentoLineaService;

	@Autowired
	private DocumentoPagoService documentoPagoService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TarjetaService tarjetaService;

	
	protected DocumentoEncabezadoMapper getMapper() {
		return new DocumentoEncabezadoMapper();
	}
	
	@Override
	public DocumentoEncabezadoForm getFacturaById(int idFactura) {
		DocumentoPagoMapper mapperPago =  new DocumentoPagoMapper();
		DocumentoLineaMapper mapperLinea =  new DocumentoLineaMapper();

		
		/* Consultar encabezado*/
		DocumentoEncabezadoForm factura = getMapper().getFormView( documentoEncabezadoService.getFacturaViewById(idFactura) );
		
		/* Consultar lineas*/
		List<DocumentoLineaForm> productos = mapperLinea.getFormListView(documentoLineaService.getLineasViewByIdEncabezado(idFactura));
		factura.setLineas(productos);
		
		/* Consultar medios de pago*/
		List<DocumentoPago> pagos = documentoPagoService.getPagosByDocEncabezadoId(idFactura);
		for (DocumentoPago pago : pagos) {
			if (pago.getTipoPago() == TipoPagoEnum.PAGO_EFECTIVO.getCodigo()){
				factura.setPagoEfectivoMonto(FormatUtil.format2DecimalsStr(pago.getImporte()));
			} else if (pago.getTipoPago() == TipoPagoEnum.PAGO_TARJETA_CREDITO.getCodigo()){

				factura.setPagoTarjetaMonto(FormatUtil.format2DecimalsStr(pago.getImporte()));
				Double importeFinal = CalculosUtil.getImporteFinalCuotas(pago.getImporte(), pago.getCoefRecargoTC(), pago.getCoeficiente());
				factura.setPagoTarjetaMontoConInteres(FormatUtil.format2DecimalsStr(importeFinal));
				String cuotasDesc = CalculosUtil.getCuotasDescription(importeFinal, pago.getCuotas(), pago.getCoeficiente()); 
					
				factura.setPagoTarjetaCuotas(cuotasDesc);
				factura.setPagoTarjetaCupon(pago.getNroCupon());
				factura.setPagoTarjetaCoefRecargoTC(FormatUtil.format4DecimalsStr(pago.getCoefRecargoTC() * 100) + " %");
				
				Tarjeta tarjeta = tarjetaService.findById(pago.getTarjeta());
				factura.setPagoTarjetaNombre(tarjeta .getNombre());
			}
			
		}
		factura.setPagos(mapperPago.getFormList(pagos));
		
		
		/* Consultar Cliente*/ 
		if (StringUtils.isBlank(factura.getClienteNro()) || factura.getClienteNro().equals("0")){
			factura.setClienteCategoria(CategoriaIvaEnum.CONSUMIDOR_FINAL.getNombre());
		} else {
			factura.setClienteCategoria(CategoriaIvaEnum.getCategoriaIvaByCodigo(ConvertionUtil.IntValueOf(factura.getClienteCategoria())));
		}
		
		return factura;
	}

	@Override
	public List<DocumentoEncabezadoForm> getFacturaAll(FiltroFactura filtro) {
		List<DocumentoEncabezadoForm> list = getMapper().getFormViewList(documentoEncabezadoService.getFacturaViewAll(filtro));
		
		return list;
	}
	
}
