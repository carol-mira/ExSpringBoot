package com.Generation.farmaciaMiranda.controller;

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

import com.Generation.farmaciaMiranda.model.Categoria;
import com.Generation.farmaciaMiranda.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {
	
		@Autowired
		private CategoriaRepository repositoryCategoria;
	
		@GetMapping
		public ResponseEntity<List<Categoria>> GetAll (){
			return  ResponseEntity.ok(repositoryCategoria.findAll());

	}
		@GetMapping("/{id}")
		public ResponseEntity<Categoria> GetById(@PathVariable long id){
			return (ResponseEntity<Categoria>) repositoryCategoria.findById(id).map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
}

		@GetMapping("/categoria/{nomeCategoria}")
		public ResponseEntity<List<Categoria>> GetNomeCategoria(@PathVariable String nomeCategoria){
			return ResponseEntity.ok(repositoryCategoria.findAllByNomeCategoriaContainingIgnoreCase(nomeCategoria));
			
			}
		@PostMapping
		public ResponseEntity<Categoria> Post (@Valid @RequestBody Categoria categoria ){
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
