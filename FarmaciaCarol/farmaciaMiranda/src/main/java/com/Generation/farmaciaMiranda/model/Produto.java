package com.Generation.farmaciaMiranda.model;

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
	private Double preçoProduto;
	
	@NotNull
	private String nomeProduto;
	
	@NotNull
	private String utilidadeProduto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categoria categoria;

	public Produto() {
		
	}

	public Produto(Long idProduto,Double preçoProduto, String nomeProduto,
			 String utilidadeProduto) {
		super();
		this.idProduto = idProduto;
		this.preçoProduto = preçoProduto;
		this.nomeProduto = nomeProduto;
		this.utilidadeProduto = utilidadeProduto;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Double getPreçoProduto() {
		return preçoProduto;
	}

	public void setPreçoProduto(Double preçoProduto) {
		this.preçoProduto = preçoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUtilidadeProduto() {
		return utilidadeProduto;
	}

	public void setUtilidadeProduto(String utilidadeProduto) {
		this.utilidadeProduto = utilidadeProduto;
	}
	
	
}
