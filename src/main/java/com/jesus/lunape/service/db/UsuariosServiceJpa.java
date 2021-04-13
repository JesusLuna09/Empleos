package com.jesus.lunape.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.jesus.lunape.model.Usuario;
import com.jesus.lunape.repository.UsuariosRepository;
import com.jesus.lunape.service.IntUsuariosService;

@Service
@Primary
public class UsuariosServiceJpa implements IntUsuariosService {

	@Autowired
	private UsuariosRepository repoUsuarios;
	
	@Override
	public List<Usuario> obtenerTodas() {
		// TODO Auto-generated method stub
		return repoUsuarios.findAll();
	}

	@Override
	public Usuario buscarPorId(Integer idUsuario) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repoUsuarios.findById(idUsuario);
		if( optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		repoUsuarios.save(usuario);
		
	}

	@Override
	public void eliminar(Integer idUsuario) {
		// TODO Auto-generated method stub
		repoUsuarios.deleteById(idUsuario);
		
	}

}
