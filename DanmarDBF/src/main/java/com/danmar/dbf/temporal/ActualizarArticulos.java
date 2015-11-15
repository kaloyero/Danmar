package com.danmar.dbf.temporal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.danmar.dbf.dao.impl.ArticuloDao;
import com.danmar.dbf.dto.ArticuloDto;


public class ActualizarArticulos {

    private static final String MYSQL_DRIVERS = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3308/DanMar";
    private static final String PASSWORD = "";
    private static final String USER = "root";
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public static void main(String[] args) {
        ActualizarArticulos query = new ActualizarArticulos();
        System.out.println("ARRANCA");
        query.actualizarArticulos();
        System.out.println("TERMINA");
    }

    public void actualizarArticulos (){
    	ArticuloDao dao = new ArticuloDao();
    	List<ArticuloDto> articulos = dao.getAll();

    	System.out.println("TAMAÑO;: " + articulos.size());
    	int c= 0;
    	List<String> insertQry =new ArrayList();
    	for (ArticuloDto dto : articulos) {
    		
    		String insert = getInsertQry(dto);
			
    		
    		insertQry.add(insert);
    		c ++;
			
    		if (c==100){
    			excecuteInsert(insertQry);
    			c=0;
    			insertQry = new ArrayList();
    		}
    		
		}
    	
    	
    	
    }
    
    private void excecuteInsert(List<String> insertQry){
    	try {
    		System.out.println("INSERT :" + insertQry.toString());
    		
            // this will load the MySQL driver, each DB has its own driver
            Class.forName(MYSQL_DRIVERS);
            // setup the connection with the DB.
            connect = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            
            for (String insert : insertQry) {
            	connect.createStatement().execute(insert);
			}
    
    	} catch (Exception e) {
    		System.out.println(e);
    	} finally {

        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            statement = null;
        }
    }
    }
    
    
    
    private String getInsertQry (ArticuloDto articulo){
    	
    	
    	StringBuffer insertQry = new StringBuffer("") ;
    	
    	insertQry.append("INSERT INTO `articulo` ( `cc1`, `cc2`, `cc3`, `cc4`, `cc5`, `articulo`, `tipo`, `precio`, `visible`) ");
    	insertQry.append("VALUES ( ");
    	insertQry.append( " '"+ articulo.getCc1() +"' ,");
    	insertQry.append( " '"+ articulo.getCc1() +"' ,");
    	insertQry.append( " '"+ articulo.getCc1() +"' ,");
    	insertQry.append( " '"+ articulo.getCc1() +"' ,");
    	insertQry.append( " '"+ articulo.getCc1() +"' ,");
    	insertQry.append( " '"+ articulo.getArticulo() +"' ,");
    	insertQry.append( " '"+ articulo.getTipo() +"' ,");
    	insertQry.append( " "+ articulo.getPrecio() +" ,");
    	insertQry.append( " "+ articulo.getVisible() +" ");
    	insertQry.append("); ");

    	return  insertQry.toString();
    }

}
