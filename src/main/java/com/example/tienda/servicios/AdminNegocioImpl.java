package com.example.tienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.tienda.entidades.Producto;
import com.example.tienda.repositorios.ProductRepository;

@Service
@Primary
public class AdminNegocioImpl implements AdminNegocio{
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Producto insertarProducto(Producto producto) {
		
		producto.setId(null);
		return repo.save(producto);
		
	}

}
