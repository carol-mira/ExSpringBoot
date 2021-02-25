package com.lojaGamer.ProjetoGame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Produto {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotNull
	private String nomeJogo;
	
	@NotNull
	private Double preçoJogo;
	
	@NotNull
	private Double idadeJogo;
	
	@ManyToOne
	@JsonIgnoreProperties("produtosCategoria")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produtosUsuario")
	private Usuario usuario;
	
	public Produto() {
		
	}

	public Produto(Long idProduto,String nomeJogo,Double preçoJogo, Double idadeJogo) {
		super();
		this.idProduto = idProduto;
		this.nomeJogo = nomeJogo;
		this.preçoJogo = preçoJogo;
		this.idadeJogo = idadeJogo;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public Double getPreçoJogo() {
		return preçoJogo;
	}

	public void setPreçoJogo(Double preçoJogo) {
		this.preçoJogo = preçoJogo;
	}

	public Double getIdadeJogo() {
		return idadeJogo;
	}

	public void setIdadeJogo(Double idadeJogo) {
		this.idadeJogo = idadeJogo;
	}
	 
	

}
