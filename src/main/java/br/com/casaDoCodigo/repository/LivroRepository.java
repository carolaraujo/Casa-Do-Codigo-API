package br.com.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.modell.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	Page<Livro> findByTituloContainingIgnoreCase(String titulo, Pageable paginacaoLivro);
	
	Optional<Livro> findByTitulo(String titulo);
	
	Optional<Livro> findByIsbn(String isbn);
}
