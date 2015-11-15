package com.danmar.dbf.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danmar.dbf.conn.ConexionDB;

public abstract class GenericDao<E> {
	public String order_by = getDefaultOrderBy();

	protected abstract String getTableName();

	protected abstract E getDto(ResultSet res) throws SQLException;

	protected abstract String getDefaultOrderBy();

	protected String getOrderBy() {
		return order_by;
	}

	protected void SetOrderBy(String orderBy) {
		this.order_by = orderBy;
	}

	/**
	 * Metodo para realizar la consulta con parametros a Access
	 */
	protected List<E> getAll(int pagina, int cantRegistros) {
		return excecutePaginatedListQry(pagina, cantRegistros);
	}

	protected List<E> getAll(int pagina, int cantRegistros, String whereClause) {
		return excecutePaginatedListQry(whereClause, pagina, cantRegistros);

	}

	protected List<E> getAll() {
		return excecuteListQry();
	}

	protected List<E> getAll(String whereClause) {
		return excecuteListQry(whereClause);
	}

	private List<E> excecuteListQry() {
		return excecuteListQry("");
	}

	private List<E> excecuteListQry(String whereClause) {
		List<E> respuesta = new ArrayList<E>();

		String sql = getQuery(whereClause);
		respuesta = excecuteQueryList(sql);
		return respuesta;
	}

	private List<E> excecutePaginatedListQry(int pagina, int cantRegistros) {
		return excecutePaginatedListQry("", pagina, cantRegistros);
	}

	private List<E> excecutePaginatedListQry(String whereClause, int pagina,
			int cantRegistros) {
		List<E> respuesta = new ArrayList<E>();

		String sql = getPaginatedQuery(whereClause, pagina, cantRegistros);

		respuesta = excecuteQueryPaginatingList(sql, 10, 2);

		return respuesta;
	}

	private String getQuery(String whereClause) {
		String sql = " SELECT * " + " FROM " + getTableName() + "  ";
		if (whereClause != null && (!whereClause.trim().equals(""))) {
			sql += " WHERE " + whereClause + "  ";
		}
		return sql;
	}

	private String getPaginatedQuery(String whereClause, int pagina,
			int cantRegistros) {

		// SI O SI ESTABLECER ORDER BY
		StringBuffer qry = new StringBuffer();
		qry.append("		SELECT * ");
		qry.append(" FROM ( ");
		qry.append("   SELECT Top " + cantRegistros + " * ");
		qry.append("    FROM ( ");
		qry.append("        SELECT TOP " + (pagina * cantRegistros) + " * ");
		qry.append("        FROM " + getTableName() + " ");
		if (whereClause != null && (!whereClause.trim().equals(""))) {
			qry.append(" WHERE " + whereClause + "  ");
		}
		qry.append(" ORDER BY " + getOrderBy() + " ");
		qry.append("    ) sub ");
		qry.append("   ORDER BY " + getOrderBy() + " DESC ");
		qry.append(" ) subOrdered ");
		qry.append(" ORDER BY " + getOrderBy() + " ");

		return qry.toString();
	}

	protected E getByIdQry(String whereClause) {
		String sql = getQuery(whereClause);

		E dto = excecuteQueryObj(sql);

		return dto;
	}

	private List<E> excecuteQueryList(String qry) {
		List<E> respuesta = new ArrayList<E>();

		try {
			PreparedStatement pstm = ConexionDB.getConn().prepareStatement(qry);

			ResultSet res = pstm.executeQuery();

			respuesta = getListado(res);
			res.close();

			ConexionDB.desconectar();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return respuesta;

	}

	private List<E> excecuteQueryPaginatingList(String qry, int pagina,
			int cantRegistros) {
		List<E> respuesta = new ArrayList<E>();

		try {
			PreparedStatement pstm = ConexionDB.getConn().prepareStatement(qry);
			ResultSet res = pstm.executeQuery();

			respuesta = getListado(res);
			res.close();

			ConexionDB.desconectar();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return respuesta;

	}

	private E excecuteQueryObj(String qry) {
		E rta = null;

		try {
			// Statement st =
			// ConexionDB.getConn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			// ResultSet.CONCUR_READ_ONLY);
			// st.setFetchSize();(1);
			// st.setMaxRows(25);
			// ResultSet res = st.executeQuery(qry );

			PreparedStatement pstm = ConexionDB.getConn().prepareStatement(qry);
			// pstm.setMaxRows(10);
			// pstm.setFetchSize(100);

			/********* PROVISORIO, BORRAR ****************/
			pstm.setMaxRows(1000);

			ResultSet res = pstm.executeQuery();

			List<E> lista = getListado(res);
			if (lista != null && lista.size() > 0) {
				rta = lista.get(0);
			}

			res.close();

			ConexionDB.desconectar();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		return rta;

	}

	protected List<E> getListado(ResultSet res) throws SQLException {
		List<E> listado = new ArrayList<E>();

		while (res.next()) {
			E dto = getDto(res);
			listado.add(dto);
		}

		return listado;
	}

}
