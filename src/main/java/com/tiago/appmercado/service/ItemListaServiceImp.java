package com.tiago.appmercado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.appmercado.model.ItemLista;
import com.tiago.appmercado.repository.ItemListaRepository;

@Service
public class ItemListaServiceImp implements IItemListaService {

	@Autowired
	private ItemListaRepository repository;

	@Override
	public ItemLista inserirItem(ItemLista itemLista) {
		return repository.save(itemLista);
	}

	@Override
	public ItemLista alterarItem(ItemLista itemLista) {

		return repository.save(itemLista);
	}

	@Override
	public void removerItem(Integer numSeq) {
		repository.deleteById(numSeq);
	}

}
