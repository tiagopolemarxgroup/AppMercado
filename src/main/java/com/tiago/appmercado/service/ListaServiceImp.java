package com.tiago.appmercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.appmercado.model.ItemLista;
import com.tiago.appmercado.model.Lista;
import com.tiago.appmercado.repository.ListaRepository;

@Service
public class ListaServiceImp implements IListaService{

	@Autowired
	private ListaRepository repository;
	
	@Override
	public Lista criarNovaLista(Lista lista) {
		return repository.save(lista);
	}

	@Override
	public void removerLista(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	public Lista fecharLista(Integer id) {
		Lista l = repository.findById(id).get();
		double total = 0.0;
		for(ItemLista item: l.getItens()) {
			total += l.getValorTotal();
		}
		l.setValorTotal(total);
		l.setStatus(1);
		return repository.save(l);	
	}

	@Override
	public Lista buscarPorId(Integer id) {
		return repository.findById(id).orElse(null);
		
	}

	@Override
	public List<Lista> buscarTodas() {
		return (List<Lista>) repository.findAll();
	}

}
