package com.lojaGamer.ProjetoGame.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lojaGamer.ProjetoGame.model.Categoria;
import com.lojaGamer.ProjetoGame.repository.RepositorioCategoria;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")// responsável por localizar o caminho
public class ControllerCategoria {

		
		@Autowired//injetar dependência para que a instaciação funcione.estou fazendo uma injeção de depêndencia.
		private RepositorioCategoria repositoryCategoria;
		
		
		@GetMapping
		public ResponseEntity<List<Categoria>> GetAll (){
			return  ResponseEntity.ok(repositoryCategoria.findAll());		
			
		}
		
		@GetMapping("/{id}")//método que procura na lista de todos , cujo o Id é oque estou colocando lá.
		public ResponseEntity<Categoria> GetById(@PathVariable long id){//PathVariable, ele da irnformação e o computador procura.
			return (ResponseEntity<Categoria>) repositoryCategoria.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/categoria/{generoJogo}")
		public ResponseEntity<List<Categoria>> GetGenero(@PathVariable String generoJogo){
			return ResponseEntity.ok(repositoryCategoria.findAllByGeneroJogoContainingIgnoreCase(generoJogo));
		}	
		
		@PostMapping
		public ResponseEntity<Categoria> Post (@Valid @RequestBody Categoria categoria ){//@Valid ele procura se é válido ou não.
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));
		}
		
		@PutMapping
		@ResponseStatus(HttpStatus.OK)
		public  ResponseEntity<Categoria> Put (@Valid @RequestBody Categoria categoria) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));
		}
		
		@DeleteMapping("/{idCategoria}")
		public void Delete(@PathVariable Long idCategoria) {
			repositoryCategoria.deleteById(idCategoria);
		}
}

