package com.tiago.appmercado.service;

import com.tiago.appmercado.model.ItemLista;

public interface IItemListaService {
	
	public ItemLista inserirItem(ItemLista itemLista);
	public ItemLista alterarItem(ItemLista itemLista);
	public void removerItem(Integer numSeq);

}
