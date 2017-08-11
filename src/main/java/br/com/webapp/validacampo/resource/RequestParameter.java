package br.com.webapp.validacampo.resource;

import java.io.Serializable;

public class RequestParameter implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String valor;
	private String tipo;
	
	public RequestParameter() {
		
	}
	
	public RequestParameter(String valor, String tipo) {
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
