package com.jesus.lunape.service;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jesus.lunape.model.Vacante;

public interface IntVacantesService {
	//metodos abstractos
	public List<Vacante> obtenerTodas();
	public Vacante buscarPorId(Integer idVacante);
	public void guardar(Vacante vacante);
	public void eliminar(Integer idVacante);
	public List<Vacante> buscarDestacadas();
	public Page<Vacante> buscarTodas(Pageable page);
	public List<Vacante> buscarByExample(Example<Vacante> example);
}