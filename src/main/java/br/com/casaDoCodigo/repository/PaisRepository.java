package br.com.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.modell.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
	
	Page<Pais> findByNomeContainingIgnoreCase(String nome, Pageable paginacaoPais);
	
	Optional<Pais> findByNome(String nome);

}
