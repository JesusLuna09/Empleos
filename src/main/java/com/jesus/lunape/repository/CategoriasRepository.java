package com.jesus.lunape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.lunape.model.Categoria;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
public interface CategoriasRepository extends JpaRepository<Categoria, Integer>{
}
