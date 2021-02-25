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

import com.lojaGamer.ProjetoGame.model.Usuario;
import com.lojaGamer.ProjetoGame.repository.RepositorioUsuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class ControllerUsuario {

	@Autowired
	private RepositorioUsuario repositoryUsuario;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> GetAll (){
		return  ResponseEntity.ok(repositoryUsuario.findAll());

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> GetById(@PathVariable long id){
		return (ResponseEntity<Usuario>) repositoryUsuario.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/usuario/{nomeUsuario}")
	public ResponseEntity<List<Usuario>> GetGenero(@PathVariable String nomeUsuario){
		return ResponseEntity.ok(repositoryUsuario.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario));
	}	
	
	@PostMapping
	public ResponseEntity<Usuario> Post (@Valid @RequestBody Usuario usuario ){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public  ResponseEntity<Usuario> Put (@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUsuario.save(usuario));
	}
	
	@DeleteMapping("/{idUsuario}")
	public void Delete(@PathVariable Long idUsuario) {
		repositoryUsuario.deleteById(idUsuario);
	}
}
