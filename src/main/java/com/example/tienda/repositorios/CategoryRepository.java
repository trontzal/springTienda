package com.example.tienda.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.tienda.entidades.Categoria;

public interface CategoryRepository extends CrudRepository<Categoria, Long>{

}
