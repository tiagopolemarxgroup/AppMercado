package com.tiago.appmercado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiago.appmercado.model.ItemLista;
@Repository
public interface ItemListaRepository extends CrudRepository<ItemLista, Integer>{

}
