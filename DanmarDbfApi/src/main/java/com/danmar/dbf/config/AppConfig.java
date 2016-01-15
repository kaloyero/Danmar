package com.danmar.dbf.config;  
  
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
  
/**
 * Clase de Configuracion
 * - Inicializa el application context
 * 
 * @author Alejandro Masciotra
 *
 */
@Configuration 
@ComponentScan("com.danmar.dbf.rest") 
@EnableWebMvc   
public class AppConfig {  

}  
