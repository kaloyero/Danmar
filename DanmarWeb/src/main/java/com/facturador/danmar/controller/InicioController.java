package com.facturador.danmar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class InicioController {

	@RequestMapping("/inicio")
	public ModelAndView getVersion(){

		
		return new ModelAndView("index");
	}
	
}
