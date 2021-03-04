package com.exerc.cio.springtdd.springTdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exerc.cio.springtdd.springTdd.model.ContatoModel;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
	
}