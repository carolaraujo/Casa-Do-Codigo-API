package br.com.casaDoCodigo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casaDoCodigo.modell.Pagamento;
import br.com.casaDoCodigo.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@GetMapping
	public ResponseEntity<List<Pagamento>> GetAll(){
		return ResponseEntity.ok(pagamentoRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Pagamento> cadastrarPagamento(@RequestBody @Valid Pagamento pagamento){
		return ResponseEntity.status(HttpStatus.OK).body(pagamentoRepository.save(pagamento));
	}
}
