package br.com.webapp.validacampo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.webapp.validacampo.resource.ParameterHelper;

@Controller
@RequestMapping("/")
public class PageController {

	@Autowired
	private ParameterHelper parametros;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("parametros", parametros.getParameters());
		return "index";
	}
	
}
