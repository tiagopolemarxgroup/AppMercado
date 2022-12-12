package com.tiago.appmercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.appmercado.model.Lista;
import com.tiago.appmercado.service.IListaService;

@RestController
@RequestMapping(value = "/listas")
public class ListaControlller {

	@Autowired
	private IListaService service;

	@PostMapping
	public ResponseEntity<Lista> adicionarNovaLista(@RequestBody Lista lista) {
		Lista res = service.criarNovaLista(lista);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@GetMapping
	public ResponseEntity<List<Lista>> buscarTodasListas() {
		return ResponseEntity.ok(service.buscarTodas());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Lista> buscarPorId(@PathVariable Integer id) {
		Lista res = service.buscarPorId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Lista> alterarLista(@PathVariable Integer id) {
		Lista res = service.fecharLista(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping(value = "/id")
	public ResponseEntity<?> removerLista(@PathVariable Integer id) {
		service.removerLista(id);
		return ResponseEntity.ok("ok");
	}

}
