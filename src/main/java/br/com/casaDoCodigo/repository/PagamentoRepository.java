package br.com.casaDoCodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.casaDoCodigo.modell.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}
