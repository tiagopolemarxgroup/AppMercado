package com.tiago.appmercado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.appmercado.model.ItemLista;
import com.tiago.appmercado.service.IItemListaService;

@RestController
@RequestMapping(value = "/intens")
public class ItemListaController {

	@Autowired
	private IItemListaService service;

	@PostMapping
	public ResponseEntity<ItemLista> inserir(@RequestBody ItemLista itemLista){
		ItemLista res = service.inserirItem(itemLista);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping(value="/{numSeq}")
	public ResponseEntity<ItemLista> alterar(@RequestBody ItemLista item, @PathVariable Integer numSeq){
		item.setNumSeq(numSeq);
		ItemLista res = service.alterarItem(item);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> removerItem(@PathVariable Integer id){
		service.removerItem(id);
		return ResponseEntity.ok("OK");
	}
	
	
}
