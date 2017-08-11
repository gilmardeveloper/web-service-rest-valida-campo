package br.com.webapp.validacampo.resource;

import java.io.Serializable;

import javax.ws.rs.core.Response.Status;

public class ResponseJson implements Serializable {

	private static final long serialVersionUID = 1L;

	private String valor;
	private String tipo;
	private Status statusText;
	private int status;
	

	public ResponseJson(RequestParameter request, Boolean result) {
		
		this.valor = request.getValor();
		this.tipo = request.getTipo();
		verifica(result);
	}

	private void verifica(Boolean result) {
		if (result) {
			setStatus(Status.BAD_REQUEST, Status.BAD_REQUEST.getStatusCode());
		} else {
			setStatus(Status.OK, Status.OK.getStatusCode());
		}
	}

	private void setStatus(Status badRequest, int statusCode) {
		this.statusText = badRequest;
		this.status = statusCode;
		
	}

	public String getValor() {
		return valor;
	}

	public String getTipo() {
		return tipo;
	}

	public Status getStatusText() {
		return statusText;
	}

	public int getStatus() {
		return status;
	}
	

}
