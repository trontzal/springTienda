package com.example.tienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.entidades.Producto;
import com.example.tienda.repositorios.ProductRepository;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	@Autowired
	private ProductRepository repo;

	@Override
	public Iterable<Producto> obtenerProductos() {

		return repo.findAll();
	}

}
