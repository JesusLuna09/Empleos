package com.jesus.lunape.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jesus.lunape.model.Categoria;

public interface IntCategoriasService {
	
	public List<Categoria> obtenerTodas();
	public Categoria buscarPorId(Integer idCategoria);
	public void guardar(Categoria categoria);
	public void eliminar(Integer idCategoria);
	public Page<Categoria>buscarTodas(Pageable page);

}
