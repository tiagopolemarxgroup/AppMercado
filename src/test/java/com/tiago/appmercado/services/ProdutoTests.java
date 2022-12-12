package com.tiago.appmercado.services;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.tiago.appmercado.model.Produto;
import com.tiago.appmercado.repository.ProdutoRepository;
import com.tiago.appmercado.service.ProdutoServiceImp;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoTests {

	@InjectMocks
	private ProdutoServiceImp serviceImp;
	@Mock
	private ProdutoRepository repository;

	private Integer existingId = 1;
	private Integer noExintingId = 100;
	private String keyword = "bolacha";
	private Produto newProduct;
	private Produto createdProduct;
	private ArrayList<Produto> listaVariosProdutos;

	@BeforeEach
	public void setup() throws Exception {
		newProduct = new Produto();
		newProduct.setNome("Bolacha");

		createdProduct = new Produto();
		createdProduct.setId(1);
		createdProduct.setNome("Bolacha");

		listaVariosProdutos = new ArrayList<>();
		Produto p1, p2;
		p1 = new Produto();
		p1.setId(1);
		p1.setNome("Bolacha");

		p2 = new Produto();
		p2.setId(2);
		p2.setNome("Teclado");
		listaVariosProdutos.add(p1);
		listaVariosProdutos.add(p2);

		Mockito.when(repository.save(newProduct)).thenReturn(createdProduct);
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(new Produto()));
		Mockito.when(repository.findById(noExintingId)).thenReturn(Optional.ofNullable(null));
		Mockito.when(repository.findAllByNomeContaining("Biscoito")).thenReturn(new ArrayList<Produto>());
		Mockito.when(repository.findAllByNomeContaining(keyword)).thenReturn(listaVariosProdutos);
	}

	@Test
	public void deveriaCadastrarProduto() {
		Assertions.assertEquals(serviceImp.criarNovoProduto(newProduct), createdProduct);
	}

	@Test
	public void deveriaRetornarPeloId() {
		Assertions.assertNotNull(serviceImp.buscarPorId(existingId));
	}

	@Test
	public void deveriaNaoEncontrarId() {
		Assertions.assertNull(serviceImp.buscarPorId(noExintingId));
	}

	@Test
	public void deveriaRetornarListaComPalavraChave() {
		Assertions.assertTrue(serviceImp.buscarPorPalavraChava(keyword).size() > 0);
	}

	@Test
	public void deveriaRetornarListaVazia() {
		Assertions.assertTrue(serviceImp.buscarPorPalavraChava("Biscoito").size() == 0);
	}

}
