package com.danmar.dbf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.danmar.dao.PaginacionDao;
import com.danmar.dbf.dto.ClienteDto;

public class ClienteDao extends GenericDao<ClienteDto> implements
		PaginacionDao<ClienteDto> {

	public static final String TABLA_NOMBRE = "clientes";

	public static final String CAMPO_NUMERO = "numero";
	public static final String CAMPO_TIPO_CLIEN = "tipo_clien";
	public static final String CAMPO_NOMBRE = "nombre";
	public static final String CAMPO_RAZON_SOC = "razon_soc";
	public static final String CAMPO_A_CARGO = "a_cargo";
	public static final String CAMPO_DIRECCION = "direccion";
	public static final String CAMPO_LOCALIDAD = "localidad";
	public static final String CAMPO_PROVINCIA = "provincia";
	public static final String CAMPO_TELEFONO = "telefono";
	public static final String CAMPO_CUIT = "cuit";
	public static final String CAMPO_DOMENTREGA = "domentrega";
	public static final String CAMPO_VENDEDOR = "vendedor";
	public static final String CAMPO_CONTACTO = "contacto";
	public static final String CAMPO_HORARIO = "horario";
	public static final String CAMPO_CATEGORIA = "categoria";
	public static final String CAMPO_DESCUENTO1 = "descuento1";
	public static final String CAMPO_DESCUENTO2 = "descuento2";
	public static final String CAMPO_DESCUENTO3 = "descuento3";
	public static final String CAMPO_DESCUENTO4 = "descuento4";
	public static final String CAMPO_DESCUENTO5 = "descuento5";
	public static final String CAMPO_DESCUENTO6 = "descuento6";
	public static final String CAMPO_CONDPAGO = "condpago";
	public static final String CAMPO_SALDO = "saldo";
	public static final String CAMPO_SALDO_NC = "saldo_nc";
	public static final String CAMPO_ULTIMOPAGO = "ultimopago";
	public static final String CAMPO_F_ULT_PAGO = "f_ult_pago";
	public static final String CAMPO_VARIOS = "varios";
	public static final String CAMPO_DOMFISCAL = "domfiscal";
	public static final String CAMPO_RET_IB = "ret_ib";

	public static final String DEFAULT_ORDER_BY	 = "numero";

	
	/**
	 * Se ejecuta la clase de consulta
	 */
	public static void main(String[] args) {

		ClienteDao access = new ClienteDao();
		access.getAll(1, 5);
	}

	public List<ClienteDto> getAll(int pagina, int cantRegistros) {
		return super.getAll(pagina, cantRegistros);
	}

	public List<ClienteDto> getAll() {
		return super.getAll();
	}

	@Override
	protected ClienteDto getDto(ResultSet res) throws SQLException {

		ClienteDto cliente = new ClienteDto();
		cliente.setCodigo(res.getInt(CAMPO_NUMERO));
		cliente.setaCargo(res.getString(CAMPO_A_CARGO));
		cliente.setCategoria(res.getString(CAMPO_CATEGORIA));
		cliente.setCondicionPago(res.getDouble(CAMPO_CONDPAGO));
		cliente.setContacto(res.getString(CAMPO_CONTACTO));
		cliente.setCuit(res.getString(CAMPO_CUIT));
		cliente.setDescuento1(res.getDouble(CAMPO_DESCUENTO1));
		cliente.setDescuento2(res.getDouble(CAMPO_DESCUENTO2));
		cliente.setDescuento3(res.getDouble(CAMPO_DESCUENTO3));
		cliente.setDescuento4(res.getDouble(CAMPO_DESCUENTO4));
		cliente.setDescuento5(res.getDouble(CAMPO_DESCUENTO5));
		cliente.setDescuento6(res.getDouble(CAMPO_DESCUENTO6));
		cliente.setDireccion(res.getString(CAMPO_DIRECCION));
		cliente.setDomicilioEntrega(res.getString(CAMPO_DOMENTREGA));
		cliente.setDomicilioFiscal(res.getString(CAMPO_DOMFISCAL));
		cliente.setfUltPago(res.getDate(CAMPO_F_ULT_PAGO));
		cliente.setHorario(res.getString(CAMPO_HORARIO));
		cliente.setLocalidad(res.getString(CAMPO_LOCALIDAD));
		cliente.setNombre(res.getString(CAMPO_NOMBRE));
		cliente.setProvincia(res.getString(CAMPO_PROVINCIA));
		cliente.setRazonSocial(res.getString(CAMPO_RAZON_SOC));
		cliente.setRetencionIb(res.getDouble(CAMPO_RET_IB));
		cliente.setSaldo(res.getDouble(CAMPO_SALDO));
		cliente.setSaldoNc(res.getDouble(CAMPO_SALDO_NC));
		cliente.setTelefono(res.getString(CAMPO_TELEFONO));
		cliente.setTipo(res.getString(CAMPO_TIPO_CLIEN));
		cliente.setUltimoPago(res.getDouble(CAMPO_ULTIMOPAGO));
		cliente.setVarios(res.getString(CAMPO_VARIOS));
		cliente.setVendedor(res.getInt(CAMPO_VENDEDOR));
	//	System.out.println(cliente.getCodigo()+ " - " + cliente.getNombre());
		return cliente;
	}

	@Override
	protected String getTableName() {
		return TABLA_NOMBRE;
	}

	public ClienteDto getById(int numero) {
		ClienteDto dto = super.getByIdQry(CAMPO_NUMERO + " =  " + numero + " ");

		return dto;
	}

	@Override
	protected String getDefaultOrderBy() {
		return DEFAULT_ORDER_BY;
	}

}
