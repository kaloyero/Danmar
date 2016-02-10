package com.danmar.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.danmar.common.Constants;

public class FormatUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	/**
	 * Agrega 2 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static Double format2Decimals (Double num){
		
		DecimalFormat decim = new DecimalFormat("#,##0.00");

//	    if (num != null){
//	    	return Double.parseDouble(decim.format(num));
//	    } else {
//	    	return null;
//	    }
	    
	    return num;
		
	}
	public synchronized static Double format4Decimals (Double num){
		
		DecimalFormat decim = new DecimalFormat("#,##0.0000");

//	    if (num != null){
//	    	return Double.parseDouble(decim.format(num));
//	    } else {
//	    	return null;
//	    }
	    
	    return num;
		
	}
	
	/**
	 * Agrega 4 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
/*	public synchronized static String format4DecimalsStr (Double num){
		DecimalFormat decim = new DecimalFormat("0.0000");
	    if (num != null){
	    	return decim.format(num);
	    } else {
	    	return Constants.ZERO;
	    }
		
	}*/
	/**
	 * Agrega 4 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String format4DecimalsStr (Double num){
		return formatDecimalsStr("#,##0.0000", num);

	}
	public synchronized static String format4DecimalsStr (String num){
		
		return format4DecimalsStr (ConvertionUtil.DouValueOf(num));
		
	}

	/**
	 * Agrega 2 decimales al parametro double
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String format2DecimalsStr (Double num){
		return formatDecimalsStr("#,##0.00", num);

	}
	public synchronized static String format2DecimalsStr (String num){
		
		return format2DecimalsStr (ConvertionUtil.DouValueOf(num));
		
	}

	
	public synchronized static String formatDecimalsStr (String format,Double num){
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		otherSymbols.setDecimalSeparator('.');
		otherSymbols.setGroupingSeparator(','); 
		DecimalFormat decim = new DecimalFormat(format, otherSymbols);
	    if (num != null){
	    	return decim.format(num);
	    } else {
	    	return Constants.ZERO;
	    }
		
	}
	
	


	/**
	 * Averigua si el numero String es menor a ZERO
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static boolean checkIfIsMinorThanZero (String num) {
		boolean isMenor = false;
		if ( StringUtils.isNotBlank(num) && "-".equals(num.trim().substring(0, 1)) ) {
			isMenor = true;
		}
		return isMenor;
	}

	/**
	 * Si el numero String es menor a 0 devuelve la cadena entre (parentesis) 
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String formatNegativeNumber (String num) {
		String numReturn = num ;  
		if (checkIfIsMinorThanZero(num)){
			numReturn = "(" + num.trim().substring(1) + ")"; 
		} else {
			numReturn = num ;
		}

		return numReturn;
	}

}
