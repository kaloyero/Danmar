package com.facturador.danmar.config;


import java.io.IOException;
import java.util.Properties;

/**
*
* @author 
*/
public class Configuration {

   Properties properties = null;

   /** Configuration file name */
   public final static String CONFIG_FILE_NAME = "config.properties";

   public static final String PROTOCOLO_DBF_API = "http://";
   public static final String PROYECTO_DBF_API = "/DanmarDbfApi";
   
   /** Data base DBF IP */
   public final static String DBF_IP = "dbfIp";
   
   private Configuration() {
       this.properties = new Properties();
       try {
           properties.load(Configuration.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME));
       } catch (IOException ex) {
           ex.printStackTrace();
       }
   }//Configuration

   /**
    * Implementando Singleton
    *
    * @return
    */
   public static Configuration getInstance() {
       return ConfigurationHolder.INSTANCE;
   }

   private static class ConfigurationHolder {

       private static final Configuration INSTANCE = new Configuration();
   }

   /**
    * Retorna la propiedad de configuracion solicitada
    *
    * @param key
    * @return
    */
   public static String getProperty(String key) {
       return getInstance().properties.getProperty(key);
   }
   
   
}