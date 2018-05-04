package com.exemplo.produto.repository.filter;

public class ProdutoFilter {
	
	private String descricao;

	public String getDescricao() {
		if(descricao == null){
			descricao = "";
		}
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
