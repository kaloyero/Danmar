package com.danmar.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;

public class DateUtil {

	static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	static SimpleDateFormat formatterHour = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	/**
	 * Recibe un String y devuelve un date  formateado
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static Date convertStringToDate (String d){
		
		Date returnDate = null;

		try {
			if (d != null){
				returnDate = formatter.parse(d);	
			}
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("ERROR (DateFormater.java) Error en el parseo de formato ");
		}

		return returnDate;
		
	}
	
	
	/**
	 * Recibe un date y devuelve un String formateado
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String convertDateToString (Date d){
		
		String resultDate = null; 
		if (d != null){
			resultDate = formatter.format(d);
		}

		return resultDate;
		
	}
	
	/**
	 * Recibe un date y devuelve un String formateado con minutos
	 * 
	 * @param d
	 * @return
	 */
	public synchronized static String convertDateToStringWithMinutes (Date d){
		
		String resultDate = null; 
		if (d != null){
			resultDate = formatterHour.format(d);
		}

		return resultDate;
		
	}

	/**
	 * Devuelve en formato String la fecha actual
	 * 
	 * @return
	 */
	public synchronized static String getStringToday (){
		Date fecha = new Date();
		String resultDate = convertDateToString(fecha);

		return resultDate;
		
	}
	
	
	/**
	 * Toma la fecha actual
	 * 
	 * @return
	 */
	public synchronized static Date getDateToday (){
		Date fecha = new Date();

		return fecha;
	}

	public synchronized static Date getDateTodayDmyFormat (){
		return  convertStringToDate(getStringToday());	
	}
	
    /**
     * Suma X minutos a una fecha especifica
     * 
     * @param fch
     * @param horas
     * @return
     */
    public synchronized static Date sumarMinutos(Date fch, int minutos) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.MINUTE, minutos);

        return new Date(cal.getTimeInMillis());
    }
	

    /**
     * Suma X meses
     * Si es <1 resta
     * 
     * @param fch
     * @param meses
     * @return
     */
    public synchronized static Date sumarMeses(Date fch, int meses) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(fch);
        cal.add(Calendar.MONTH, meses);
        return cal.getTime();
    }
    public synchronized static Date sumarMeses(String fch, int meses) {
    	return sumarMeses(convertStringToDate(fch), meses);
    }

    
    /**
     * Suma X horas a una fecha especifica
     * 
     * @param fch
     * @param horas
     * @return
     */
    public synchronized static Date sumarHoras(Date fch, int horas) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.HOUR, horas);

        return new Date(cal.getTimeInMillis());
    }

    /**
     * Suma X dias a una fecha especifica
     * 
     * @param fch
     * @param dias
     * @return
     */
    public synchronized static Date sumarDias(Date fch, int dias) {
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(fch.getTime());
        cal.add(Calendar.DATE, dias);

        return new Date(cal.getTimeInMillis());
    }

    public synchronized static String sumarDias(String fch, int dias) {
        return convertDateToString(sumarDias(convertStringToDate(fch), -1));
    }

    
    /**
     * Devuelve el dia de la semana
     * 
     * @param fch
     * @return
     */
    public synchronized static int getDiaDeLaSemana(Date fch) {
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTime(fch);
    	return cal.get(Calendar.DAY_OF_WEEK) -1;
    }
    
    public synchronized static int getYear(Date fch) {
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTime(fch);
    	return cal.get(Calendar.YEAR);
    }

    public synchronized static int getYear(String fch) {
    	Date fchDate = convertStringToDate(fch);
    	GregorianCalendar cal = new GregorianCalendar();
    	cal.setTime(fchDate);
    	return cal.get(Calendar.YEAR);
    }

    
    public synchronized static String getDiaDeLaSemanaName(Date fch) {
    	 SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated  
    	   return simpleDateformat.format(fch);
    }
 
    public synchronized static Date getPrimerDiaMes(Date fch) {
    	
        Calendar cal = new GregorianCalendar();
        cal.setTime(fch);
        cal.set(Calendar.DATE,1);

        return cal.getTime();
    }
    
    public synchronized static Date getPrimerDiaMes(String fch) {
    	if (StringUtils.isBlank(fch)){
    		return null;
    	}
        return getPrimerDiaMes(convertStringToDate(fch));
    }
    
    
    public synchronized static int getHora(Date fch) {
    	DateFormat hourFormat = new SimpleDateFormat("HH");
    	return Integer.parseInt(hourFormat.format(fch));
    	
    	
    }
    
    
    public synchronized static boolean compararMesAnioIguales(Date fecha1, Date fecha2) {
    	
    	if (fecha1 == null || fecha2 == null ){
    		return false;
    	}
    	
        Calendar fechaA = new GregorianCalendar();
        fechaA.setTimeInMillis(fecha1.getTime());
        
        Calendar fechaB = new GregorianCalendar();
        fechaB.setTimeInMillis(fecha2.getTime());
        
        boolean sonIguales = false;
        if (fechaA.get(Calendar.MONTH) == fechaB.get(Calendar.MONTH) &&
        		fechaA.get(Calendar.YEAR) == fechaB.get(Calendar.YEAR)){
        	sonIguales = true;
        }
        
        return sonIguales;
   	}

    public synchronized static boolean compararMesAnioIguales(String fecha1, String fecha2) {
    	if (StringUtils.isBlank(fecha1) || StringUtils.isBlank(fecha2) ){
    		return false;
    	} 
    	return compararMesAnioIguales(convertStringToDate(fecha1),convertStringToDate(fecha2));

    
    }
    
    public synchronized static int getMinutes(int hour, int minutes) {
    	return (hour * 60) + minutes;
    }
    
    public synchronized static int setHourInfForm(int minutes) {

    	if (minutes == 0){
    		return 0;
    	} else {
    		return minutes / 60;	
    	}
    	
    }
    
    public synchronized static int setMinutesInfForm(int minutes) {
    	if (minutes == 0){
    		return 0;
    	} else {
        	return minutes % 60;	
    	}
    }
}
