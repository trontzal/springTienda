package com.example.tienda.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.tienda.entidades.Producto;
import com.example.tienda.servicios.AdminNegocio;
import com.example.tienda.servicios.UsuarioNegocio;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UsuarioNegocio usuarioNegocio;
	
	@Autowired
	private AdminNegocio adminNegocio;
	
	@GetMapping
	public String index(Model modelo) {
		modelo.addAttribute("productos", usuarioNegocio.obtenerProductos());
		return "index";
	}
	
	@GetMapping("categorias")
	@ResponseBody
	public String categorias() {
		
		return usuarioNegocio.obtenerCategorias().toString();
	}
	
	@GetMapping("admin")
	public String admin(Producto producto) {
		producto.setNombre(""); // para evitar valores nulos
		return "admin";
	}
	
	@PostMapping("admin")
	public String adminPost(@Valid Producto producto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "admin";
		}
		adminNegocio.insertarProducto(producto);
		return "redirect:/";
	}
	
}
