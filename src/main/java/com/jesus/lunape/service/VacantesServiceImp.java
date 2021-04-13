package com.jesus.lunape.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import com.jesus.lunape.model.Categoria;
import com.jesus.lunape.model.Vacante;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VacantesServiceImp implements IntVacantesService{
	//atributo 
	private List<Vacante> lista = null;
	
	//metodo constructor
	public VacantesServiceImp() {
		// TODO Auto-generated method stub
		lista = new LinkedList<Vacante>();
		try {
			Vacante v1 = new Vacante();
			v1.setId(1);
			v1.setNombre("Arquitecto");
			v1.setDescripcion("Relacionado con la construccion");
			v1.setFecha(LocalDate.parse("12-01-2021", 
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v1.setSalario(9500.0);
			v1.setDestacado(1);
			v1.setEstatus("Aprobado");
			v1.setImagen("tres.png");
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Desarrollador");
			c1.setDescripcion("Relacionado con contabilidad y auditoria");
			v1.setCategoria(c1);
			lista.add(v1);
			//************************************
			Vacante v2 = new Vacante();
			v2.setId(2);
			v2.setNombre("Contador");
			v2.setDescripcion("Para llevar la contabilidad general");
			v2.setFecha(LocalDate.parse("20-01-2021",
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v2.setSalario(8500.0);
			v2.setDestacado(0);
			v2.setEstatus("Aprobada");
			v2.setImagen("tres.png");
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Informatico");
			c2.setDescripcion("Desarrollo de productos");
			v2.setCategoria(c2);
			lista.add(v2);
			//***********************************
			Vacante v3 = new Vacante();
			v3.setId(3);
			v3.setNombre("Tecnico de Mantenimiento");
			v3.setDescripcion("Para soporte a equipos");
			v3.setFecha(LocalDate.parse("02-02-2021",
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v3.setSalario(5500.0);
			v3.setDestacado(1);
			v3.setEstatus("Eliminada");
			v3.setImagen("tres.png");
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Programador");
			c3.setDescripcion("Desarrollo de productos");
			v3.setCategoria(c3);
			lista.add(v3);
			
			//************************************
			Vacante v4 = new Vacante();
			v4.setId(4);
			v4.setNombre("Ingeniero electrico");
			v4.setDescripcion("Para desarrollo de aplicaciones IOT");
			v4.setFecha(LocalDate.parse("20-01-2021",
					DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			v4.setSalario(14500.0);
			v4.setDestacado(0);
			v4.setEstatus("Creada");
			Categoria c4 = new Categoria();
			c4.setId(4);
			c4.setNombre("Diseñador");
			c4.setDescripcion("Desarrollo de productos");
			v4.setCategoria(c4);
			lista.add(v4);
			
		}catch(DateTimeParseException ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		
	}
	
		@Override
		public List<Vacante> obtenerTodas() {
			// TODO Auto-generated method stub
		return lista;
	}
		@Override
		public Vacante buscarPorId(Integer idVacante) {
			// TODO Auto-generated method stub
		for(Vacante vacante : obtenerTodas()) {
			if ( vacante.getId() == idVacante) {
				return vacante;
			}
		}
		return null;
}

		@Override
		public void guardar(Vacante vacante) {
			// TODO Auto-generated method stub
			lista.add(vacante);
			
		}

		@Override
		public void eliminar(Integer idVacante) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Vacante> buscarDestacadas() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Vacante> buscarTodas(Pageable page) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Vacante> buscarByExample(Example<Vacante> example) {
			// TODO Auto-generated method stub
			return null;
		}
}
