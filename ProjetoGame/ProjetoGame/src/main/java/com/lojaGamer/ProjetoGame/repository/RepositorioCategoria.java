package com.lojaGamer.ProjetoGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lojaGamer.ProjetoGame.model.Categoria;

@Repository
public interface RepositorioCategoria extends JpaRepository<Categoria, Long >{
public List<Categoria>findAllByGeneroJogoContainingIgnoreCase (String generoJogo);

}
