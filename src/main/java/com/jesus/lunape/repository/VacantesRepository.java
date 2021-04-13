package com.jesus.lunape.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.lunape.model.Vacante;

public interface VacantesRepository extends JpaRepository<Vacante, Integer>{
	//query metthods (Metodos personalizados por un campo en especifico)
	List<Vacante> findByEstatus(String estatus);
	List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, String estatus);
	List<Vacante> findBySalarioBetween(double s1,double s2);
	List<Vacante> findByEstatusIn(String[] estatus);
}
