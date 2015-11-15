package com.danmar.dao;

import java.util.List;

public interface PaginacionDao<E> {
	
	/**
	 * Metodo para realizar la consulta con parametros a Access
	 * 
	 * @param pagina Pagina a mostrar. Comienza en 1.
	 * @param cantRegistros cantidad de registros que muestra
	 * @return
	 */
	public List<E> getAll(int pagina, int cantRegistros);

}
