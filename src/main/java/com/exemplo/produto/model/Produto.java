package com.exemplo.produto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = -490977659777224232L;
	
	@Id
	@SequenceGenerator(name = "prod_seq", sequenceName = "prod_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	private Long codigo;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Descrição é obrigatório.")
	private String descricao;
	
	@Column(nullable = false, length = 50)
	@NotBlank(message = "Marca é obrigatório.")
	private String marca;
	
	@Column(nullable = false, precision=2)
	@NotNull(message = "Preço é obrigatório.")
	private BigDecimal preco;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Data é uma informação obrigatória.")
	private Date data;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

}
