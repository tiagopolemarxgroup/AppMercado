package com.tiago.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiago.appmercado.model.Produto;
import com.tiago.appmercado.repository.ProdutoRepository;

@Component
public class ProdutoServiceImp implements IProdutoService {

	@Autowired
	private ProdutoRepository repository;

	@Override
	public Produto criarNovoProduto(Produto produto) {
		if(produto.getNome() == null || produto.getNome().length() == 0) 
			return null;
		return repository.save(produto);
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		this.buscarPorId(produto.getId());
		return repository.save(produto);
	}

	@Override
	public List<Produto> listarTodos() {
		return (List<Produto>) repository.findAll();
	}

	@Override
	public List<Produto> buscarPorPalavraChava(String key) {
		return repository.findAllByNomeContaining(key);
	}

	@Override
	public Produto buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
	}

}
