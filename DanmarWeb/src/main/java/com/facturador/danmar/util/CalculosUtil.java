package com.facturador.danmar.util;


public class CalculosUtil {

	
	public synchronized static Double  calcularPrecioConInteres(Double precio, Double interes){
		
		Double total = precio + calcularInteres(precio, interes);
	    return total;
		
	}
	
	public synchronized static Double  calcularPrecioConInteres(Double precio){
		return calcularPrecioConInteres(precio, 21.00);
	}

	public synchronized static Double  calcularInteres(Double precio, Double interes){
		
		Double total = precio * (interes / 100);
	    return total;
		
	}

	
}
