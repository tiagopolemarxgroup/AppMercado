package com.tiago.appmercado.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiago.appmercado.model.Lista;

@Repository
public interface ListaRepository extends CrudRepository<Lista, Integer> {

}
