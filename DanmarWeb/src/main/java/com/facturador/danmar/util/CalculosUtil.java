package com.facturador.danmar.util;

import com.danmar.utils.FormatUtil;


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

	public synchronized static String getCuotasDescription(Double monto,Double recargoTC,int cantCuotas, Double coeficienteCuota){
		Double importeFinal = getImporteFinalCuotas(monto, recargoTC, coeficienteCuota);
		Double importeCuota = importeFinal  / cantCuotas;
		
		String descripcion = cantCuotas + " cuota(s) de $ " + FormatUtil.format2DecimalsStr(importeCuota) + " ( "+coeficienteCuota+"% - $ "+FormatUtil.format2DecimalsStr(importeFinal)+") " ;
		
		return descripcion;
	}

	public synchronized static String getCuotasDescription(Double importeFinal,int cantCuotas, Double coeficienteCuota){
		Double importeCuota = importeFinal  / cantCuotas;
		
		String descripcion = cantCuotas + " cuota(s) de $ " + FormatUtil.format2DecimalsStr(importeCuota) + " ( "+coeficienteCuota+"% - $ "+FormatUtil.format2DecimalsStr(importeFinal)+") " ;
		
		return descripcion;
	}
	
	public synchronized static Double getImporteFinalCuotas(Double monto,Double recargoTC, Double coeficienteCuota){
		Double importeCuotasTC = coeficienteCuota * monto  ;
		Double importeRecargoTc = recargoTC *  importeCuotasTC;

		Double importeFinal = importeCuotasTC +  importeRecargoTc;
		
		return importeFinal;
	}
}
