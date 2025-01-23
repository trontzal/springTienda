package com.example.tienda.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tienda.servicios.UsuarioNegocio;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UsuarioNegocio usuarioNegocio;
	
	@GetMapping
	@ResponseBody
	public String index() {
		return usuarioNegocio.obtenerProductos().toString();
	}
}
