package com.example.tienda;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tienda.entidades.Producto;
import com.example.tienda.repositorios.ProductRepository;

@SpringBootApplication
public class TiendaSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TiendaSpringApplication.class, args);
	}
	
	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {

		repo.save(Producto.builder().nombre("Prueba").precio(new BigDecimal(1234)).build());
		
		for(var p: repo.findAll()) {
			System.out.println(p);
		}
		
	}

}
