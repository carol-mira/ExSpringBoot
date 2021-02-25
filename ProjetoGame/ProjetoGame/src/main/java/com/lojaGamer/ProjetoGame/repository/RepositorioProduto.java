package com.lojaGamer.ProjetoGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaGamer.ProjetoGame.model.Produto;

public interface RepositorioProduto extends JpaRepository<Produto, Long > {
	public List<Produto>findAllByNomeJogoContainingIgnoreCase (String nomeJogo);
}
