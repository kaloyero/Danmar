package com.facturador.danmar.form;

import java.util.ArrayList;
import java.util.List;

public class PaginadoForm<E> {

	private int tamanio;
	
	private List<E> lista;

	public PaginadoForm() {
		lista = new ArrayList<E>();
	}

	public int getTamanio() {
		return tamanio;
	}

	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

	public List<E> getLista() {
		return lista;
	}

	public void setLista(List<E> lista) {
		this.lista = lista;
	}

	
}
