package com.tiago.appmercado.service;

import java.util.List;

import com.tiago.appmercado.model.Lista;

public interface IListaService {
	
	public Lista criarNovaLista(Lista lista);
	public void removerLista(Integer id);
	public Lista fecharLista(Integer id);
	public Lista buscarPorId(Integer id);
	public List<Lista> buscarTodas(); 

}
