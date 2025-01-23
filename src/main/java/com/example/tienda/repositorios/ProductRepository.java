package com.example.tienda.repositorios;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.example.tienda.entidades.Producto;

public interface ProductRepository extends CrudRepository<Producto, Long>{
	
	Iterable<Producto> findByNombreContains(String nombre);
	
	Iterable<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);

}
