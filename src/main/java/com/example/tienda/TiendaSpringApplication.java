package com.example.tienda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tienda.servicios.UsuarioNegocio;

@SpringBootApplication
public class TiendaSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}
	
	@Autowired
	private UsuarioNegocio usuarioNegocio;

	@Override
	public void run(String... args) throws Exception {
		
		for(var p: usuarioNegocio.obtenerProductos()) {
			System.out.println(p);
		}
	}
	
}