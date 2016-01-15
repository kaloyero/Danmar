package com.facturador.danmar.bean;


public enum Acento {

	A_ACENTO (-20,"Á");
 
    private final int codigo; 
    private final String letra; 

 
    Acento (int codigo,String letra) { 
        this.letra = letra;
        this.codigo = codigo;
    } 

    private int getCodigo() {
		return codigo;
	}

	private String getLetra() {
		return letra;
	}

    public static String getLetraAcento(int codigo){
        String letra= "?";
        for (Acento acento : Acento.values()) {
        	if (codigo == acento.getCodigo()){
        		letra = acento.getLetra();
        	}
		}
        
        return letra;
    }

} 
  