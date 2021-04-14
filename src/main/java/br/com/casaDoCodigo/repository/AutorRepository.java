package br.com.casaDoCodigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.modell.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

	List<Autor> findByNomeContainingIgnoreCase(String nome);
	
	public Optional<Autor> findByEmail(String email);
}
