package org.Generation.blogPessoal.controller;

import java.util.List;

import javax.validation.Valid;

import org.Generation.blogPessoal.model.Postagem;
import org.Generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;


	@RestController
	@RequestMapping("/postagens")
	@CrossOrigin("*")
	public class PostagemController{
		
		@Autowired
		private PostagemRepository repository;
		
		
		@GetMapping
		public ResponseEntity<List<Postagem>> Carolinda (){
			return  ResponseEntity.ok(repository.findAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Postagem> GetById(@PathVariable long id){
			return (ResponseEntity<Postagem>) repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/título/{título}")
		public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String título){
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(título));
			
		}
		
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Postagem EuFuiNoShowDaIvete (@Valid @RequestBody Postagem post) {
			return repository.save(post);
		}
		@PutMapping
		@ResponseStatus(HttpStatus.OK)
		public Postagem SuperShow (@Valid @RequestBody Postagem put) {
			return repository.save(put);
		}
		
		@DeleteMapping("/{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
	}
		
	}
