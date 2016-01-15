package com.facturador.danmar.bean;


public enum TipoPagoEnum {

	PAGO_EFECTIVO ("EF",1), 
	PAGO_TARJETA_CREDITO ("TC",2), 
	PAGO_TARJETA_DEBITO ("TD",3);
 
    private final String nombre; 
    private final int codigo; 
 
    TipoPagoEnum (String nombre,int codigo) { 
        this.nombre = nombre;
        this.codigo = codigo;
    } 
 
    public String getNombre() { return nombre; }
    public int  getCodigo() { return codigo; }
    
    
    
    
} 
  