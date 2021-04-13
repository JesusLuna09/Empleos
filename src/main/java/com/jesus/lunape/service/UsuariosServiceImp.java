package com.jesus.lunape.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.jesus.lunape.model.Usuario;

@Service
public class UsuariosServiceImp implements IntUsuariosService {
	
	private List<Usuario> lista = null;
	
	public UsuariosServiceImp() {
	
		lista = new LinkedList<Usuario>();
		
		try {
			 Usuario u1 = new Usuario();
	            u1.setId(1);
	            u1.setNombre("Juan");
	            u1.setEmail("juan@gmail.com");
	            u1.setUsername("juan10");
	            u1.setPassword("123456");
	            u1.setEstatus(1);
	            u1.setFechaRegistro(LocalDate.parse("02-02-2021",
	                    DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	            lista.add(u1);
	           
	            Usuario u2 = new Usuario();
	            u2.setId(2);
	            u2.setNombre("Natalia");
	            u2.setEmail("natalia@gmail.com");
	            u2.setUsername("natalia20");
	            u2.setPassword("654321");
	            u2.setEstatus(1);
	            u2.setFechaRegistro(LocalDate.parse("08-02-2021",
	                    DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	            lista.add(u2);
	           
	            Usuario u3 = new Usuario();
	            u3.setId(3);
	            u3.setNombre("Armando");
	            u3.setEmail("armando@gmail.com");
	            u3.setUsername("armando50");
	            u3.setPassword("12345678");
	            u3.setEstatus(0);
	            u3.setFechaRegistro(LocalDate.parse("19-02-2021",
	                    DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	            lista.add(u3);
			
		}catch(DateTimeParseException ex) {
			System.out.println("Error : " + ex.getMessage());
		}
	}
	
	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		for(Usuario usuario : lista) {
			if ( usuario.getId() == idUsuario) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		
	}
}
