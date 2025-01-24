package com.example.tienda.servicios;

import com.example.tienda.entidades.Categoria;
import com.example.tienda.entidades.Producto;

import dtos.CategoriaConProductosDto;

public interface UsuarioNegocio {

	Iterable<Producto> obtenerProductos();
	Iterable<Categoria> obtenerCategorias();
	CategoriaConProductosDto obtenerCategoriaPorId(Long id);
	
}
