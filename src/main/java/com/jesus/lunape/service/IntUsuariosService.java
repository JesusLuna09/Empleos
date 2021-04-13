package com.jesus.lunape.service;

import java.util.List;

import com.jesus.lunape.model.Usuario;

public interface IntUsuariosService {
	
	public List<Usuario> obtenerTodas();
	public void guardar(Usuario usuario);
	public void eliminar(Integer idUsuario);
	public Usuario buscarPorId(Integer idUsuario);
	
}
