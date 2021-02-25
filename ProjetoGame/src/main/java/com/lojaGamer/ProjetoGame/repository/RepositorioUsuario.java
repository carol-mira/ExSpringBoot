package com.lojaGamer.ProjetoGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaGamer.ProjetoGame.model.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
	public List<Usuario>findAllByNomeUsuarioContainingIgnoreCase (String nomeUsuario);

}
