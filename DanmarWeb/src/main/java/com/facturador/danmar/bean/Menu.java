package com.facturador.danmar.bean;

import java.util.List;

import com.danmar.dbf.dao.impl.ClienteDao;
import com.danmar.dbf.dto.ClienteDto;

public class Menu {

	
	public static void main(String[] args) {
		ClienteDao dao = new ClienteDao();
		List<ClienteDto> lista = dao.getAll();
		
	}
	
}
