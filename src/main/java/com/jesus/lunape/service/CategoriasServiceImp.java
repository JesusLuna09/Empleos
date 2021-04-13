package com.jesus.lunape.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jesus.lunape.model.Categoria;

@Service
public class CategoriasServiceImp implements IntCategoriasService{
	//atributo 
	private List<Categoria> lista = null;
	
	//metodo constructor
	public CategoriasServiceImp() {
		// TODO Auto-generated method stub
		lista = new LinkedList<Categoria>();
	
			Categoria c1 = new Categoria();
			c1.setId(1);
			c1.setNombre("Desarrollador");
			c1.setDescripcion("Relacionado con la construccion");
			lista.add(c1);
			//************************************
			Categoria c2 = new Categoria();
			c2.setId(2);
			c2.setNombre("Informatico");
			c2.setDescripcion("Para llevar la contabilidad general");
			lista.add(c2);
			//***********************************
			Categoria c3 = new Categoria();
			c3.setId(3);
			c3.setNombre("Programador");
			c3.setDescripcion("Para desarrollo de aplicaciones web");
			lista.add(c3);
			
			//************************************
			Categoria c4 = new Categoria();
			c4.setId(4);
			c4.setNombre("Diseñador");
			c4.setDescripcion("Para desarrollo de diseño");
			lista.add(c4);
			
			//*************************************
			Categoria c5 = new Categoria();
			c5.setId(5);
			c5.setNombre("Informatica");
			c5.setDescripcion("Para desarrollo de aplicaciones web");
			lista.add(c5);
			
	}
		@Override
		public List<Categoria> obtenerTodas() {
			// TODO Auto-generated method stub
		return lista;
	}
		@Override
		public Categoria buscarPorId(Integer idCategoria) {
			// TODO Auto-generated method stub
		for(Categoria c : lista) {
			if (c.getId() == idCategoria) {
				return c;
			}
		}
		return null;
}

		@Override
		public void guardar(Categoria categoria) {
			// TODO Auto-generated method stub
			lista.add(categoria);
			
		}
		@Override
		public void eliminar(Integer idCategoria) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public Page<Categoria> buscarTodas(Pageable page) {
			// TODO Auto-generated method stub
			return null;
		}
}