package com.java.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/agente")
	public String getAgentes() {
		return "Agentes/agente-view";
	}
	
	@GetMapping("/via")
	public String getVias() {
		return "Vias/via-view";
	}
}
