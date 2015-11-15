package com.danmar.error;


public class ErrorRespuestaBean {

	private boolean valido=false;
	
	private String descripcion="";
	
	private String advertencia="";
	
	private String error="";
	
	private Integer codError;

	public ErrorRespuestaBean(){
	}

	public ErrorRespuestaBean(boolean valido){
		this.valido = valido;
	}

	
	public ErrorRespuestaBean(boolean valido, String error){
		this.error=error;
		this.valido=valido;
	}


	public boolean isValido() {
		return valido;
	}


	public void setValido(boolean valido) {
		this.valido = valido;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getAdvertencia() {
		return advertencia;
	}


	public void setAdvertencia(String advertencia) {
		this.advertencia = advertencia;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public Integer getCodError() {
		return codError;
	}


	public void setCodError(Integer codError) {
		this.codError = codError;
	}
	
	
}
