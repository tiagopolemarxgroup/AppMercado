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
		return repository.save(produto);
	}

	@Override
	public Produto alterarProduto(Produto produto) {
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> buscarPorPalavraChava(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto buscarPorId(Integer id) {
		return repository.findById(id).get();
	}

}
