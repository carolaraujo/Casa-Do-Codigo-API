package br.com.casaDoCodigo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casaDoCodigo.modell.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
	
	Page<Estado> findByNomeContainingIgnoreCase(String nome, Pageable paginacaoEstado);
	
	Optional<Estado> findByNome(String nome);

}
