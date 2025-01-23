package com.example.tienda.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.tienda.servicios.UsuarioNegocio;



@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UsuarioNegocio usuarioNegocio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", usuarioNegocio.obtenerProductos());
		return "index";
	}
}
