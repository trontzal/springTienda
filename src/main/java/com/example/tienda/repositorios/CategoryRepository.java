package com.example.tienda.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.tienda.entidades.Categoria;

public interface CategoryRepository extends CrudRepository<Categoria, Long>{

	@Query("from Categoria c join fetch c.productos where c.id = :id")
	Categoria obtenerCategoriaPorIdConProductos(@Param("id") Long id);
}
