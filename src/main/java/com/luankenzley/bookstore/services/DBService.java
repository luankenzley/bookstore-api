package com.luankenzley.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luankenzley.bookstore.domain.Categoria;
import com.luankenzley.bookstore.domain.Livro;
import com.luankenzley.bookstore.repositories.CategoriaRepository;
import com.luankenzley.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		// Setando Categorias

		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Didático", "Livros didáticos");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias");

		// Setando livros

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Aprendendo Português", "Galo Cego", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "Sergio Cortella - Biografia", "Sergio Cortella", "lorem ipsum", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2, l3));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));
	}
}
