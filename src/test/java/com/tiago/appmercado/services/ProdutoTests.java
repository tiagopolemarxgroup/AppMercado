package com.tiago.appmercado.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tiago.appmercado.model.Produto;
import com.tiago.appmercado.service.IProdutoService;

@SpringBootTest
public class ProdutoTests {

	@Autowired
	IProdutoService service;
	//private static ProdutoServiceImp service;
	private static Integer idFound = 1;
	private static Integer idNotFound = 100;
	private static Produto newProduct;
	private static Produto createdProduct;

	@BeforeAll
	public static void setup() {
		System.out.println("Configuração");
		newProduct = new Produto();
		newProduct.setNome("Bolacha");

		createdProduct = new Produto();
		createdProduct.setNome("Biscoito");
		createdProduct.setId(1);

		/*service = Mockito.mock(ProdutoServiceImp.class);
		Mockito.when(service.criarNovoProduto(createdProduct)).thenReturn(new Produto());
		Mockito.when(service.buscarPorId(idFound)).thenReturn(createdProduct);
		Mockito.when(service.buscarPorId(idNotFound)).thenReturn(null);
		Mockito.when(service.buscarPorPalavraChava("b")).thenReturn(new ArrayList<Produto>());
		Mockito.when(service.listarTodos()).thenReturn(new ArrayList<Produto>());
		Mockito.when(service.alterarProduto(createdProduct)).thenReturn(createdProduct);*/
	}

	@Test
	public void shouldStoreProduct() {
		assertThat(service.criarNovoProduto(newProduct));
	}

}
