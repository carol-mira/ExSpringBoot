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
import org.springframework.web.bind.annotation.RestController;

import com.Generation.farmaciaMiranda.model.Produto;
import com.Generation.farmaciaMiranda.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

 	@Autowired
 		private ProdutoRepository repositoryProduto;

 	@GetMapping
public ResponseEntity<List<Produto>> GetAll() {
	return ResponseEntity.ok(repositoryProduto.findAll());
}

@GetMapping("/{id}")
public ResponseEntity<Produto> GetById(@PathVariable long id) {
	return repositoryProduto.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}

@GetMapping("/produto/{nomeProduto}")
public ResponseEntity<List<Produto>> GetByDepartamento(@PathVariable String departamento) {
	return ResponseEntity.ok(repositoryProduto.findAllByNomeProdutoContainingIgnoreCase(departamento));
}

@PostMapping
public ResponseEntity<Produto> Post (@Valid @RequestBody Produto produto) {
	return ResponseEntity.status(HttpStatus.CREATED).body(repositoryProduto.save(produto));
}

@PutMapping
public ResponseEntity<Produto> Put (@RequestBody Produto produto) {
	return ResponseEntity.status(HttpStatus.OK).body(repositoryProduto.save(produto));
}

@DeleteMapping("/{idCategoria}")
public void delete(@PathVariable long idCategoria) {
	repositoryProduto.deleteById(idCategoria);
}
}
