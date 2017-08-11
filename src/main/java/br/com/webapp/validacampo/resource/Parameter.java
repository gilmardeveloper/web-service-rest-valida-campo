package br.com.webapp.validacampo.resource;

import java.io.Serializable;

public class Parameter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String tipo;
	
	public Parameter(int codigo, String tipo) {
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
	
}
