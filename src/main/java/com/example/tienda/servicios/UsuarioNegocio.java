package com.example.tienda.servicios;

import com.example.tienda.entidades.Producto;

public interface UsuarioNegocio {

	Iterable<Producto> obtenerProductos();
	
}
