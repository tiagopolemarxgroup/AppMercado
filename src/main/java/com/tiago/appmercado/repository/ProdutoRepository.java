package com.tiago.appmercado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiago.appmercado.model.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer>{

}
