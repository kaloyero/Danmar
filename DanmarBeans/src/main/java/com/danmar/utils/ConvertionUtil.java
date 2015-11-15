package com.danmar.utils;

import org.apache.commons.lang.math.NumberUtils;


public class ConvertionUtil {

	public synchronized static String StrValueOf (Double var){
		String res = null;
		if (var != null){
			res = String.valueOf(var);
		} 
		return res;
	}
	public synchronized static String StrValueOf (Integer var){
		String res = null;
		if (var != null){
			res = String.valueOf(var);
		} 
		return res;
	}
	public synchronized static Integer IntValueOf (String var){
		Integer res = null;
		//Remuevo las comas
		if (var != null){
			var = var.replace(",", "");
			if (NumberUtils.isNumber(var)){
				res = Integer.valueOf(var);
			} 
		}
		return res;
	}
	public synchronized static Double DouValueOf (String var){
		Double res = null;
		//Remuevo las comas
		if (var != null){
			var = var.replace(",", "");
			if (NumberUtils.isNumber(var)){
				res = Double.valueOf(var);
			}
		}
		return res;
	}
	
}
