package com.facturador.danmar.form.mapper;

import java.util.ArrayList;
import java.util.List;

import com.danmar.mapper.Mapper;

public abstract class MapperImpl<E,F> implements Mapper<E,F>{

	
	public  List<E> getEntidadList(List<F> list) {
		List<E> entityList = new ArrayList<E>();
		
		for (F form : list) {
			entityList.add((E)getEntidad(form));
		}
	
		return entityList;
	}

	
	public List<F> getFormList(List<E> list) {
		List<F> formList = new ArrayList<F>();
		
		for (E ent : list) {
			formList.add((F)getForm(ent));
		}
	
		return formList;
	}
}