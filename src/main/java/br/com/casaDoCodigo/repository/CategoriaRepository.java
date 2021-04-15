package br.com.casaDoCodigo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.modell.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	List<Categoria> findByNomeContainingIgnoreCase(String nome);
	
	public Page<Categoria> findByNomeContainingIgnoreCase (String nome, Pageable paginacaoCat);
	
	public Optional<Categoria> findByNome(String nome);
}
