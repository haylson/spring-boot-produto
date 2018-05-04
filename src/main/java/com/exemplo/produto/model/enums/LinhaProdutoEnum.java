package com.exemplo.produto.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum LinhaProdutoEnum {
	
	AMARELA("A","Amarela"),
	BRANCA("B","Branca"),
	MARRON("M","Marron");
	
	private String valor;
	private String descricao;
	
	LinhaProdutoEnum(String valor, String descricao){
		this.valor = valor;
		this.descricao = descricao;
	}
	
	public static LinhaProdutoEnum getInstance(String valor){
		for(LinhaProdutoEnum linhaProdutoEnum: LinhaProdutoEnum.values()){
			if(linhaProdutoEnum.getValor().equals(valor)){
				return linhaProdutoEnum;
			}
		}
		return null;
	}
	
	public static List<String> obterLinhaProdutos(){
		List<String> linhasProduto = new ArrayList<String>();
		for(LinhaProdutoEnum linhaProdutoEnum: LinhaProdutoEnum.values()){
			linhasProduto.add(linhaProdutoEnum.descricao);
		}
		return linhasProduto;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
