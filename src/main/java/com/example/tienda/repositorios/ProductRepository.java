package com.example.tienda.repositorios;

import java.math.BigDecimal;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.example.tienda.entidades.Producto;

public interface ProductRepository extends CrudRepository<Producto, Long>{
	
	Set<Producto> findByNombreContains(String nombre);
	
	Set<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
	
	Set<Producto> findCategoriaById(Long id);

}
