package com.facturador.danmar.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.danmar.dbf.dto.ClienteDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;
import com.danmar.dbf.dto.filtro.FiltroCliente;
import com.danmar.utils.ConvertionUtil;
import com.facturador.danmar.config.Configuration;
import com.facturador.danmar.dao.ClienteDao;
import com.facturador.danmar.dao.GenericDao;
import com.facturador.danmar.model.Cliente;
import com.facturador.danmar.service.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl extends GenericServiceImpl<Cliente> 
			implements ClienteService {

	private static final String SERVICIO_CONSULTA_CLIENTES = "/servicio/getAllCliente";
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	protected GenericDao<Cliente> getDao() {
		return clienteDao;
	}

	@Override
	public List<Cliente> searchByFiltros(FiltroCliente filtro) {
		return clienteDao.searchByFiltros(filtro);
	}

	public ClienteDto[] getAllClientesDbf() {
		RestTemplate restTemplate = new RestTemplate();
		//Consulto al servicio DBF por los clientes
		ClienteDto[] array = restTemplate.getForObject(Configuration.PROTOCOLO_DBF_API+
				Configuration.getProperty(Configuration.DBF_IP)+
				Configuration.PROYECTO_DBF_API+SERVICIO_CONSULTA_CLIENTES , 
				ClienteDto[].class);

		return array;
		
	}
	
	public List<Cliente> mapperDtoToModel ( ClienteDto[] clientesDto){

		//los guardo en un array
		List<Cliente> lista = new ArrayList<Cliente>();
		for (ClienteDto dto : clientesDto) {
			Cliente ent  =returnModelByDto(dto);
			lista.add(ent);
		}

		return lista;
	}
	
	protected Cliente returnModelByDto( ClienteDto dto){
		Cliente ent  =new Cliente();
		ent.setId(dto.getCodigo());
		ent.setTipoCliente(ConvertionUtil.IntValueOf(dto.getTipo()));
		ent.setCategoria(ConvertionUtil.IntValueOf(dto.getCategoria()));
		ent.setNombre(dto.getNombre());
		ent.setRazonSocial(dto.getRazonSocial());
		ent.setDireccion(dto.getDireccion());
		ent.setLocalidad(dto.getLocalidad());
		ent.setProvincia(dto.getProvincia());
		ent.setTelefono(dto.getTelefono());
		ent.setCuit(dto.getCuit());
		ent.setSaldo(dto.getSaldo());
		ent.setSaldoNC(dto.getSaldoNc());
		ent.setRetIIBB(dto.getRetencionIb());
			
		return ent;
	}
	
	public void insertList ( List<Cliente> clientes){
		for (Cliente cliente : clientes) {
			try { 
				clienteDao.saveOrUpdate(cliente);
			} catch (Exception e){
				System.out.println("Error insertando cliente Id: " + cliente.getId());
			}
		}
	}
	
	@Override
	public int getAllFilterCount(FiltroCliente filtro) {
		return clienteDao.getAllFilterPagingCount(filtro);
	}

}