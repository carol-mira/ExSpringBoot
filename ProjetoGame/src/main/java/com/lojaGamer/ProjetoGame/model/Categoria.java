package com.lojaGamer.ProjetoGame.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Categoria {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategoria;
	
	@NotNull(message = "Qual seria o genêro" )
	private String generoJogo;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produtosCategoria;
	
	public Categoria () { //boa prática, você dá opções que as pessoas possam testar e declarar algo vazio, assim facilita e permite  processos de testagem
		
	}
	
	public Categoria(Long idCategoria, String generoJogo) {
		super();
		this.idCategoria = idCategoria;
		this.generoJogo = generoJogo;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getGeneroJogo() {
		return generoJogo;
	}

	public void setGeneroJogo(String generoJogo) {
		this.generoJogo = generoJogo;
	}

	public List<Produto> getProdutosCategoria() {
		return produtosCategoria;
	}

	public void setProdutosCategoria(List<Produto> produtosCategoria) {
		this.produtosCategoria = produtosCategoria;
	}
	
}
