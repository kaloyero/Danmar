package com.danmar.dbf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.danmar.dao.PaginacionDao;
import com.danmar.dbf.dto.ArticuloDto;
import com.danmar.dbf.dto.filtro.FiltroArticulo;

public class ArticuloDao extends GenericDao<ArticuloDto> implements PaginacionDao<ArticuloDto>{
	
	public static final String TABLA_NOMBRE		 = "stock";
	
	public static final String CAMPO_CODIGO		 = "codigo";
	public static final String CAMPO_SUBCODIGO	 = "subcodigo";
	public static final String CAMPO_CC1	 = "cc1";
	public static final String CAMPO_CC2	 = "cc2";
	public static final String CAMPO_CC3	 = "cc3";
	public static final String CAMPO_CC4	 = "cc4";
	public static final String CAMPO_CC5	 = "cc5";
	public static final String CAMPO_RECAMBIO	 = "recambio";
	public static final String CAMPO_ARTICULO	 = "articulo";
	public static final String CAMPO_DESC_ADIC	 = "desc_adic";
	public static final String CAMPO_DESCAMPLIA	 = "descamplia";
	public static final String CAMPO_TIPO_ART	 = "tipo_art";
	public static final String CAMPO_LINEA	 = "linea";
	public static final String CAMPO_PRECIO_LP	 = "precio_lp";
	public static final String CAMPO_COSTO	 = "costo";
	public static final String CAMPO_PRECIO	 = "precio";
	public static final String CAMPO_PRECIO_MAY	 = "precio_may";
	public static final String CAMPO_MANODEOBRA	 = "manodeobra";
	public static final String CAMPO_TIEMPO	 = "tiempo";
	public static final String CAMPO_EXISTENTES	 = "existentes";
	public static final String CAMPO_RESERVADOS	 = "reservados";
	public static final String CAMPO_CANMAXIMA	 = "canmaxima";
	public static final String CAMPO_CANMINIMA	 = "canminima";
	public static final String CAMPO_DESCUENTOS	 = "descuentos";
	public static final String CAMPO_GANANCIA	 = "ganancia";
	public static final String CAMPO_GANANCIAMY	 = "gananciamy";
	public static final String CAMPO_LISPRE_AUX	 = "lispre_aux";
	public static final String CAMPO_ORIGEN	 = "origen";
	public static final String CAMPO_FECCOMPRA	 = "feccompra";
	public static final String CAMPO_FACCOMPRA	 = "faccompra";
	public static final String CAMPO_PROVEEDOR	 = "proveedor";
	public static final String CAMPO_DTO_PROV_1	 = "dto_prov_1";
	public static final String CAMPO_DTO_PROV_2	 = "dto_prov_2";
	public static final String CAMPO_COD_PROV	 = "cod_prov";
	public static final String CAMPO_MONEDA_COS	 = "moneda_cos";
	public static final String CAMPO_FECCAMPREC	 = "feccamprec";
	public static final String CAMPO_VARIACION	 = "variacion";
	public static final String CAMPO_VARMIN	 = "varmin";
	public static final String CAMPO_VARMAY	 = "varmay";
	public static final String CAMPO_FVARMIN	 = "fvarmin";
	public static final String CAMPO_FVARMAY	 = "fvarmay";
	public static final String CAMPO_VISIBLE	 = "visible";

	public static final String DEFAULT_ORDER_BY	 = "articulo";

	
   /**
    * Se ejecuta la clase de consulta
    */
    public static void main(String[] args) {
        
    	ArticuloDao access = new ArticuloDao();
//    	//List<ArticuloDto> listado = access.getAll();
//    	FiltroArticulo filtro = new FiltroArticulo();
//    	//filtro.setArticulo("Solen.Arr.Indiel Chev.C-20");
//    	filtro.setCc1("C6");
//    	filtro.setCc2("23");
//    	filtro.setCc3("0710");
//    	filtro.setTipo("01");
//    	access.searchByFiltros(filtro,1,5);
//    	
//    	access.getById("Solen.Arr.Indiel Chev.C-20");
    	System.out.println("Empieza");
    	access.getAll();
    	System.out.println("tERMINA");
    	
    }

	    
	    @Override
	protected String getTableName() {
		return TABLA_NOMBRE;
	}
	

	public List<ArticuloDto> getAll(int pagina, int cantRegistros) {
		return super.getAll(pagina, cantRegistros);
	}   
	    
	public List<ArticuloDto> getAll() {
		return super.getAll();
	}   

	@Override
	protected ArticuloDto getDto(ResultSet res) throws SQLException {
        	ArticuloDto articulo = new ArticuloDto();

        	articulo.setArticulo(res.getString(CAMPO_ARTICULO));
        	articulo.setCanMaxima(res.getInt(CAMPO_CANMAXIMA));
        	articulo.setCanMinima(res.getInt(CAMPO_CANMINIMA));
        	articulo.setCc1(res.getString(CAMPO_CC1));
        	articulo.setCc2(res.getString(CAMPO_CC2));
        	articulo.setCc3(res.getString(CAMPO_CC3));
        	articulo.setCc4(res.getString(CAMPO_CC4));
        	articulo.setCc5(res.getString(CAMPO_CC5));
        	articulo.setCodigoProv(res.getString(CAMPO_COD_PROV));
        	articulo.setCosto(res.getDouble(CAMPO_COSTO));
        	articulo.setDescuentoAdicional(res.getString(CAMPO_DESC_ADIC));
        	articulo.setDescuentoProv1(res.getString(CAMPO_DTO_PROV_1));
        	articulo.setDescuentoProv2(res.getString(CAMPO_DTO_PROV_2));
        	articulo.setDescuentos(res.getString(CAMPO_DESCUENTOS));
        	articulo.setExistentes(res.getString(CAMPO_EXISTENTES));
        	articulo.setFacturaCompra(res.getInt(CAMPO_FACCOMPRA));
        	articulo.setfCamprec(res.getDate(CAMPO_FECCAMPREC));
        	articulo.setFechaCompra(res.getDate(CAMPO_FECCOMPRA));
        	articulo.setfVarmay(res.getDate(CAMPO_FVARMAY));
        	articulo.setfVarmin(res.getDate(CAMPO_FVARMIN));
        	articulo.setGanancia(res.getDouble(CAMPO_GANANCIA));
        	articulo.setGananciaMy(res.getDouble(CAMPO_GANANCIAMY));
        	articulo.setLinea(res.getString(CAMPO_LINEA));
        	articulo.setListaPrecioAux(res.getDouble(CAMPO_LISPRE_AUX));
        	articulo.setManoDeObra(res.getString(CAMPO_MANODEOBRA));
        	articulo.setMonedaCos(res.getString(CAMPO_MONEDA_COS));
        	articulo.setOrigen(res.getString(CAMPO_ORIGEN));
        	articulo.setPrecio(res.getDouble(CAMPO_PRECIO));
        	articulo.setPrecioLp(res.getDouble(CAMPO_PRECIO_LP));
        	articulo.setPrecioMayorista(res.getDouble(CAMPO_PRECIO_MAY));
        	articulo.setProveedor(res.getString(CAMPO_PROVEEDOR));
        	articulo.setRecambio(res.getString(CAMPO_RECAMBIO));
        	articulo.setReservados(res.getString(CAMPO_RESERVADOS));
        	articulo.setTiempo(res.getString(CAMPO_TIEMPO));
        	articulo.setTipo(res.getString(CAMPO_TIPO_ART));
        	articulo.setVariacion(res.getString(CAMPO_VARIACION));
        	articulo.setVarMay(res.getString(CAMPO_VARMAY));
        	articulo.setVarMin(res.getString(CAMPO_VARMIN));
        	articulo.setVisible(res.getString(CAMPO_VISIBLE));

        	//System.out.println(articulo.getArticulo());
        	return articulo;

	}

	public ArticuloDto getById (String nombreArticulo){
		ArticuloDto dto = super.getByIdQry(CAMPO_ARTICULO+" like '"+nombreArticulo+"' ");
		
		return dto;
	}
	
	public  List<ArticuloDto> searchByFiltros(FiltroArticulo filtro,int pagina, int cantRegistros) {
		
		StringBuffer whereClause = new StringBuffer("1=1 ");
		
		if (filtro.getArticulo() != null && ( ! filtro.getArticulo().trim().equals(""))){
			whereClause.append(" AND " + CAMPO_ARTICULO +  " like '%"+filtro.getArticulo().trim()+"%' ");
		}
		if (filtro.getCc1() != null && ( ! filtro.getCc1().trim().equals(""))){
			whereClause.append(" AND " + CAMPO_CC1 +  " like '%"+filtro.getCc1().trim()+"%' ");
		}
		if (filtro.getCc2() != null && ( ! filtro.getCc2().trim().equals(""))){
			whereClause.append(" AND " + CAMPO_CC2 +  " like '%"+filtro.getCc2().trim()+"%' ");
		}
		if (filtro.getCc3() != null && ( ! filtro.getCc3().trim().equals(""))){
			whereClause.append(" AND " + CAMPO_CC3 +  " like '%"+filtro.getCc3().trim()+"%' ");
		}
		if (filtro.getTipo() != null && ( ! filtro.getTipo().trim().equals(""))){
			whereClause.append(" AND " + CAMPO_TIPO_ART +  " like '%"+filtro.getTipo().trim()+"%' ");
		}
		
		return super.getAll(pagina,  cantRegistros,whereClause.toString());
	}

	@Override
	protected String getDefaultOrderBy() {
		return DEFAULT_ORDER_BY;
	}


	
}
