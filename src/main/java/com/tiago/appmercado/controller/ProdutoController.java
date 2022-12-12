package com.tiago.appmercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.appmercado.model.Produto;
import com.tiago.appmercado.service.IProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private IProdutoService service;

	@PostMapping
	public ResponseEntity<Produto> salvar(@RequestBody Produto produto) {
		Produto p = service.criarNovoProduto(produto);

		if (p != null) {
			return ResponseEntity.status(201).body(p);
		}

		return ResponseEntity.badRequest().build();

	}

	@GetMapping("/search")
	public ResponseEntity<List<Produto>> recuperarPorPalavraChave(@RequestParam(name = "K") String keyword) {
		return ResponseEntity.ok(service.buscarPorPalavraChava(keyword));
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarTodos(){
		return ResponseEntity.ok(service.listarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
		Produto produto = service.buscarPorId(id);

		if (produto != null) {
			return ResponseEntity.ok(produto);
		}

		return ResponseEntity.notFound().build();
	}

}
