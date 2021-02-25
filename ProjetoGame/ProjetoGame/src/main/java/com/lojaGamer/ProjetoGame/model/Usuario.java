package com.lojaGamer.ProjetoGame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuarioLong;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String nomeUsuario;
	
	@CPF
	@Size (max = 11)
	private Double cpf;
	
	@NotNull
	private Double idade;
	
	@NotNull
	private String email;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produtosUsuario;

	public Usuario() {
		
	}
	
	public Usuario(Long idUsuarioLong, String nomeUsuario, Double cpf,
			Double idade, String email) {
		super();
		this.idUsuarioLong = idUsuarioLong;
		this.nomeUsuario = nomeUsuario;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
	}

	public Long getIdUsuarioLong() {
		return idUsuarioLong;
	}

	public void setIdUsuarioLong(Long idUsuarioLong) {
		this.idUsuarioLong = idUsuarioLong;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Double getCpf() {
		return cpf;
	}

	public void setCpf(Double cpf) {
		this.cpf = cpf;
	}

	public Double getIdade() {
		return idade;
	}

	public void setIdade(Double idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Produto> getProdutosUsuario() {
		return produtosUsuario;
	}

	public void setProdutosUsuario(List<Produto> produtosUsuario) {
		this.produtosUsuario = produtosUsuario;
	}
	
	

}
