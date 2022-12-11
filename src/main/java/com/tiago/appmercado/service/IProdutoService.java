package com.tiago.appmercado.service;

import java.util.List;

import com.tiago.appmercado.model.Produto;

public interface IProdutoService {
	
	public Produto criarNovoProduto(Produto produto);
	public Produto alterarProduto(Produto produto);
	public List<Produto> listarTodos();
	public List<Produto> buscarPorPalavraChava(String key);
	public Produto buscarPorId(Integer id);

}
