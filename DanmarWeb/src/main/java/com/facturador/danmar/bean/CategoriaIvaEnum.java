package com.facturador.danmar.bean;

import org.apache.commons.lang.StringUtils;

public enum CategoriaIvaEnum {

	CONSUMIDOR_FINAL ("Consumidor Final","1"), 
	RESPONSABLE_NO_INSCRIPTO ("Responsable No Inscripto","2"),
	RESPONSABLE_INSCRIPTO("Responsable Inscripto","3"),
	EXCENTO ("Excento","4"),
	NO_RESPONSABLE ("No Responsable","5"),
    MONOTRIBUTO ("Monotributo","6");
 
    private final String nombre; 
    private final String codigo; 
 
    CategoriaIvaEnum (String nombre,String codigo) { 
        this.nombre = nombre;
        this.codigo = codigo;
    } 
 
    public String getNombre() { return nombre; }
    public String  getCodigo() { return codigo; }
    
     public static String getCategoriaIvaByCodigo(String codigo){
        return getCategoriaIvaObjByCodigo(codigo).getNombre();     
    }

    public static String getCategoriaIvaByNombre(String nombre){
        return getCategoriaIvaObjByNombre(nombre).getCodigo();     
    }
    
    public static CategoriaIvaEnum getCategoriaIvaObjByCodigo(String codigo){
        String buscar = StringUtils.trim(codigo);
        CategoriaIvaEnum categoria = CONSUMIDOR_FINAL; 
        
        
    	switch (buscar) {  //ejemplo de switch
        case "1": 
        	categoria = CONSUMIDOR_FINAL; 
        	break;
        case "2": 
        	categoria = RESPONSABLE_NO_INSCRIPTO; 
    		break;
        case "3": 
        	categoria = RESPONSABLE_INSCRIPTO; 
    		break;
        case "4": 
        	categoria = EXCENTO; 
    		break;
        case "5": 
        	categoria = NO_RESPONSABLE; 
    		break;
        case "6": 
        	categoria = MONOTRIBUTO; 
    		break;
        default:
            System.out.println("Error Categoria IVA");
            break;
    	}
    	
        return categoria;     
    }
    
    public static CategoriaIvaEnum getCategoriaIvaObjByNombre(String nombre){
        String buscar = StringUtils.trim(nombre);
        CategoriaIvaEnum categoria = CONSUMIDOR_FINAL; 

        if (CategoriaIvaEnum.CONSUMIDOR_FINAL.getCodigo().equals(buscar)){
        	categoria = CONSUMIDOR_FINAL;
        } else if (CategoriaIvaEnum.RESPONSABLE_NO_INSCRIPTO.getCodigo().equals(buscar)){
        	categoria = RESPONSABLE_NO_INSCRIPTO;
        } else if (CategoriaIvaEnum.RESPONSABLE_INSCRIPTO.getCodigo().equals(buscar)){
        	categoria = RESPONSABLE_INSCRIPTO;
        } else if (CategoriaIvaEnum.EXCENTO.getCodigo().equals(buscar)){
        	categoria = EXCENTO;
        } else if (CategoriaIvaEnum.NO_RESPONSABLE.getCodigo().equals(buscar)){
        	categoria = NO_RESPONSABLE;
        } else if (CategoriaIvaEnum.MONOTRIBUTO.getCodigo().equals(buscar)){
        	categoria = MONOTRIBUTO;
        } else {
        	System.out.println("Error Categoria IVA");
        }

    	
        return categoria;     
    }    
    
    
} 
  