package com.facturador.danmar.bean;

import org.apache.commons.lang.StringUtils;

public enum CategoriaIvaEnum {

	CONSUMIDOR_FINAL ("Consumidor Final","1","B"), 
	RESPONSABLE_NO_INSCRIPTO ("Responsable No Inscripto","2","B"),
	RESPONSABLE_INSCRIPTO("Responsable Inscripto","3","A"),
	EXCENTO ("Excento","4","B"),
	NO_RESPONSABLE ("No Responsable","5","B"),
    MONOTRIBUTO ("Monotributo","6","B");
 
    private final String nombre; 
    private final String codigo; 
    private final String letra; 
 
    CategoriaIvaEnum (String nombre,String codigo,String letra) { 
        this.nombre = nombre;
        this.codigo = codigo;
        this.letra = letra;
    } 
 
    public String getNombre() { return nombre; }
    public String  getCodigo() { return codigo; }
	public String getLetra() {	return letra; }        
    
     public static String getCategoriaIvaByCodigo(int codigo){
        return getCategoriaIvaObjByCodigo(codigo).getNombre();     
    }

    public static String getCategoriaIvaByNombre(String nombre){
        return getCategoriaIvaObjByNombre(nombre).getCodigo();     
    }
    
    public static CategoriaIvaEnum getCategoriaIvaObjByCodigo(int codigo){
        String buscar = String.valueOf(codigo);
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
        String buscar = StringUtils.trim(nombre).replace("\"", "");
        CategoriaIvaEnum categoria = CONSUMIDOR_FINAL; 

        if (CategoriaIvaEnum.CONSUMIDOR_FINAL.getNombre().equalsIgnoreCase(buscar)){
        	categoria = CONSUMIDOR_FINAL;
        } else if (CategoriaIvaEnum.RESPONSABLE_NO_INSCRIPTO.getNombre().equalsIgnoreCase(buscar)){
        	categoria = RESPONSABLE_NO_INSCRIPTO;
        } else if (CategoriaIvaEnum.RESPONSABLE_INSCRIPTO.getNombre().equalsIgnoreCase(buscar)){
        	categoria = RESPONSABLE_INSCRIPTO;
        } else if (CategoriaIvaEnum.EXCENTO.getNombre().equalsIgnoreCase(buscar)){
        	categoria = EXCENTO;
        } else if (CategoriaIvaEnum.NO_RESPONSABLE.getNombre().equalsIgnoreCase(buscar)){
        	categoria = NO_RESPONSABLE;
        } else if (CategoriaIvaEnum.MONOTRIBUTO.getNombre().equalsIgnoreCase(buscar)){
        	categoria = MONOTRIBUTO;
        } else {
        	System.out.println("Error Categoria IVA");
        }

    	
        return categoria;     
    }


    
    
    
} 
  