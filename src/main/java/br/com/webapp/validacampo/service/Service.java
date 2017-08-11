package br.com.webapp.validacampo.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.safeguard.interfaces.Check;
import br.com.safeguard.types.ParametroTipo;
import br.com.webapp.validacampo.resource.Parameter;
import br.com.webapp.validacampo.resource.ParameterHelper;
import br.com.webapp.validacampo.resource.ResponseJson;
import br.com.webapp.validacampo.resource.RequestParameter;

@Component
@Path("/")
public class Service {
	
	@Autowired
	private Check check;
	
	@Autowired
	private ParameterHelper parameters;
		
	@Path("valida/{valor}/telefone")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseJson validateTelefone(@PathParam("valor") String valor) {
		Boolean result = hasError(valor, ParametroTipo.TELEFONE);
		return new ResponseJson(new RequestParameter(valor, "telefone"), result);
	}
	
	@Path("valida/{valor}/cpf")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseJson validateCpf(@PathParam("valor") String valor) {
		Boolean result = hasError(valor, ParametroTipo.CPF);
		return new ResponseJson(new RequestParameter(valor, "cpf"), result);
	}
	
	@Path("valida/{valor}/cnpj")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseJson validateCnpj(@PathParam("valor") String valor) {
		
		Boolean result = hasError(valor, ParametroTipo.CNPJ);
		return new ResponseJson(new RequestParameter(valor, "cnpj"), result);
	}
	
	@Path("valida")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseJson validate(RequestParameter request) {
		Boolean result = hasError(request);
		return new ResponseJson(request, result);
	}

	@Path("parametro")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ParameterHelper parameters() {
		return parameters;
	}
	
	@Path("parametro/{index}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Parameter parameter(@PathParam("index") int index) {
		return parameters.getParameter(index);
	}
	
	private Boolean hasError(RequestParameter solicitacao) {
		return check.elementOf(solicitacao.getValor(), parameters.getType(solicitacao.getTipo())).validate().hasError();
	}
	
	private Boolean hasError(String valor, ParametroTipo cpf) {
		return check.elementOf(valor, cpf).validate().hasError();
	}
}
