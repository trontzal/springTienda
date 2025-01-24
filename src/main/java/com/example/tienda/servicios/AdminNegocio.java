package com.example.tienda.servicios;

import com.example.tienda.entidades.Categoria;
import com.example.tienda.entidades.Producto;

public interface AdminNegocio extends UsuarioNegocio{

	Producto insertarProducto(Producto producto);
	Categoria insertarCategoria(Categoria categoria);
}
