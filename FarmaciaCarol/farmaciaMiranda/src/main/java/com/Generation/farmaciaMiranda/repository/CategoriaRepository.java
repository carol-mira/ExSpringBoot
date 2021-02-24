package com.Generation.farmaciaMiranda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Generation.farmaciaMiranda.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria>findAllByNomeCategoriaContainingIgnoreCase (String nomeCategoria);
}
