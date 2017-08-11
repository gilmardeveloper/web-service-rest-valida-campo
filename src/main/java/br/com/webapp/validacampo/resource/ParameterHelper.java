package br.com.webapp.validacampo.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.safeguard.types.ParametroTipo;

@Component
public class ParameterHelper implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Parameter> parameters;

	public ParameterHelper() {
		parameters = new ArrayList<Parameter>();
		loadList();
	}

	private void loadList() {
		Arrays.asList(ParametroTipo.values()).forEach( item -> parameters.add(new Parameter(item.ordinal(), item.name().toLowerCase())) );
	}
	
	public List<Parameter> getParameters(){
		return parameters;
	}
	
	public Parameter getParameter(int index) {
		return parameters.get(index);
	}
	
	public ParametroTipo getType(String name) {
		return ParametroTipo.valueOf(new String(name).toUpperCase());
	}
	
}
