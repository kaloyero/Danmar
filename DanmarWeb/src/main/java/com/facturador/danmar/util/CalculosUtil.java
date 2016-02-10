package com.facturador.danmar.util;

import com.danmar.utils.ConvertionUtil;
import com.danmar.utils.FormatUtil;

public class CalculosUtil {

	public synchronized static Double calcularPrecioConInteres(Double precio,
			Double interes) {

		Double total = precio + calcularInteres(precio, interes);
		return total;

	}

	public synchronized static Double calcularPrecioConInteres(Double precio) {
		return calcularPrecioConInteres(precio, 21.00);
	}

	public synchronized static Double calcularInteres(Double precio,
			Double interes) {

		Double total = precio * (interes / 100);
		return total;

	}

	public synchronized static String getCuotasDescription(Double monto,
			Double recargoTC, int cantCuotas, Double coeficienteCuota) {
		Double importeFinal = getImporteFinalCuotas(monto, recargoTC,
				coeficienteCuota);
		Double importeCuota = importeFinal / cantCuotas;

		String descripcion = cantCuotas + " cuota(s) de $ "
				+ FormatUtil.format2DecimalsStr(importeCuota) + " ( "
				+ coeficienteCuota + "% - $ "
				+ FormatUtil.format4DecimalsStr(importeFinal) + ") ";

		return descripcion;
	}

	public synchronized static String getCuotasDescription(Double importeFinal,
			int cantCuotas, Double coeficienteCuota) {
		Double importeCuota = importeFinal / cantCuotas;

		String descripcion = cantCuotas + " cuota(s) de $ "
				+ FormatUtil.format2DecimalsStr(importeCuota) + " ( "
				+ coeficienteCuota + "% - $ "
				+ FormatUtil.format4DecimalsStr(importeFinal) + ") ";

		return descripcion;
	}

	public synchronized static Double getImporteFinalCuotas(Double monto,
			Double recargoTC, Double coeficienteCuota) {
		Double importeCuotasTC = coeficienteCuota * monto;
		Double importeRecargoTc = recargoTC * importeCuotasTC;

		Double importeFinal = importeCuotasTC + importeRecargoTc;

		return importeFinal;
	}

	public synchronized static int codificateNumberFromCodes(String cc1,String cc2,String cc3,String cc4,String cc5){
		String id = cc1.trim() + "1" +  cc2.trim() + "2"
				+  cc3.trim()+ "3" + cc4.trim()+ "4"
				+  cc5.trim();

		int idCodificado = codificateNumberFromLetter(id);
		
		return idCodificado;
	}

	
	public synchronized static int codificateNumberFromLetter(String codigo){
		String cadena = codigo.toUpperCase()
				.replace("/","69")
				.replace("-","80")
				.replace("A","81")
				.replace("B","82")
				.replace("C","83")
				.replace("D","84")
				.replace("E","85")
				.replace("F","86")
				.replace("G","87")
				.replace("H","88")
				.replace("I","89")
				.replace("J","90")
				.replace("K","91")
				.replace("L","92")
				.replace("M","93")
				.replace("N","94")
				.replace("O","95")
				.replace("P","96")
				.replace("Q","97")
				.replace("R","98")
				.replace("S","99")
				.replace("T","70")
				.replace("U","71")
				.replace("V","72")
				.replace("W","73")
				.replace("X","74")
				.replace("Y","75")
				.replace("Z","76");
		
		String strCod = cadena;
		if (cadena.length()>9){		
			int e = cadena.length() - 9;
			strCod = cadena.substring( e, cadena.length()-1  );
		}
		
		Integer id = Integer.parseInt(strCod);

		
		return id;
	}

}
