package com.example.tienda;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tienda.entidades.Producto;
import com.example.tienda.servicios.AdminNegocio;
import com.example.tienda.servicios.UsuarioNegocio;

@SpringBootApplication
public class TiendaSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}
	
	@Autowired
	private UsuarioNegocio usuarioNegocio;
	
	@Autowired
	private AdminNegocio adminNegocio;

	@Override
	public void run(String... args) throws Exception {
		
		adminNegocio.insertarProducto(Producto.builder().nombre("Prueba 3").precio(new BigDecimal(200)).build());
		
		for(var p: usuarioNegocio.obtenerProductos()) {
			System.out.println(p);
		}
	}
	
}