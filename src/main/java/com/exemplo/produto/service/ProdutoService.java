package com.exemplo.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.produto.model.Produto;
import com.exemplo.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Produto save(Produto produto){
		return repository.saveAndFlush(produto);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Produto> findByDescricao(String descricao){
		return repository.findByDescricaoContainingIgnoreCase(descricao);
	}
	

}
