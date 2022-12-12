package com.tiago.appmercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiago.appmercado.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	
	public List<Produto> findAllByNomeContaining(String nome);
}
