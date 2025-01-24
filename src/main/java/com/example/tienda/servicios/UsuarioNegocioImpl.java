package com.example.tienda.servicios;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tienda.entidades.Categoria;
import com.example.tienda.entidades.Producto;
import com.example.tienda.repositorios.CategoryRepository;
import com.example.tienda.repositorios.ProductRepository;

import dtos.CategoriaConProductosDto;
import dtos.ProductoDto;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio{
	
	@Autowired
	private ProductRepository repoProducto;
	
	@Autowired
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
	public CategoriaConProductosDto obtenerCategoriaPorId(Long id) {
		
		Categoria c = repoCategoria.findById(id).orElse(null);
		Set<ProductoDto> productos = repoProducto.findByCategoriaId(id);
		CategoriaConProductosDto categoriaDto = new CategoriaConProductosDto(c.getId(), c.getCodigo(), c.getNombre(),
				c.getDescripcion(), productos);
		return categoriaDto;
	}
}
