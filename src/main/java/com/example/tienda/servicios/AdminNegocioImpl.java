package com.example.tienda.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.tienda.entidades.Categoria;
import com.example.tienda.entidades.Producto;
import com.example.tienda.repositorios.CategoryRepository;
import com.example.tienda.repositorios.ProductRepository;

@Service
@Primary
public class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio{
	
	@Autowired
	private ProductRepository repoProducto;
	
	private CategoryRepository repoCategoria;

	@Override
	public Producto insertarProducto(Producto producto) {
		
		producto.setId(null);
		return repoProducto.save(producto);
		
	}

	@Override
	public Categoria insertarCategoria(Categoria categoria) {
		
//		categoria.setId(null);
		return repoCategoria.save(categoria);
	}

}
