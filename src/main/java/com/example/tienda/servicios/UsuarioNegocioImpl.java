package com.example.tienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.entidades.Categoria;
import com.example.tienda.entidades.Producto;
import com.example.tienda.repositorios.CategoryRepository;
import com.example.tienda.repositorios.ProductRepository;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	@Autowired
	private ProductRepository repoProducto;
	
	private CategoryRepository repoCategoria;

	@Override
	public Iterable<Producto> obtenerProductos() {

		return repoProducto.findAll();
	}

	@Override
	public Iterable<Categoria> obtenerCategorias() {

		return repoCategoria.findAll();
	}

	@Override
	public Categoria obtenerCategoriaPorId(Long id) {
		
		return repoCategoria.findById(id).orElse(null);
	}

}
