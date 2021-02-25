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

import com.lojaGamer.ProjetoGame.model.Produto;
import com.lojaGamer.ProjetoGame.repository.RepositorioProduto;



@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ControllerProduto {
	
	@Autowired
	private RepositorioProduto repositoryProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> GetAll (){
		return  ResponseEntity.ok(repositoryProduto.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return (ResponseEntity<Produto>) repositoryProduto.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/produto/{nomeJogo}")
	public ResponseEntity<List<Produto>> GetGenero(@PathVariable String nomeJogo){
		return ResponseEntity.ok(repositoryProduto.findAllByNomeJogoContainingIgnoreCase(nomeJogo));
	}	
	
	@PostMapping
	public ResponseEntity<Produto> Post (@Valid @RequestBody Produto produto ){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryProduto.save(produto));
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public  ResponseEntity<Produto> Put (@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryProduto.save(produto));
	}
	
	@DeleteMapping("/{idProduto}")
	public void Delete(@PathVariable Long idProduto) {
		repositoryProduto.deleteById(idProduto);
	}
}
