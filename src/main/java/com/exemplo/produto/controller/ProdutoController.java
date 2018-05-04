package com.exemplo.produto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exemplo.produto.model.Produto;
import com.exemplo.produto.service.ProdutoService;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	//Tela principal do Crud onde sao listados todos os produtos
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/listagemProdutos");
		mv.addObject("produtos", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Produto produto) {
		ModelAndView mv = new ModelAndView("/cadastroProduto");
		mv.addObject("produto", produto);
		return mv;
	}
	
	//Vai para tela de edição de produtos (mesma tela de adição, contudo é enviado para a view um objeto que já existe)
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Produto produto, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(produto);
		}
		service.save(produto);
		return findAll();
	}
	
	@GetMapping("/find/{descricao}")
	public List<Produto> findByDescricao(String descricao) {
		
		return service.findByDescricao(descricao);
	}

}
