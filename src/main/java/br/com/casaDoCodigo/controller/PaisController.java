package br.com.casaDoCodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.casaDoCodigo.modell.Pais;
import br.com.casaDoCodigo.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	@Autowired
	private PaisRepository paisRepository;
	
	@GetMapping
	public ResponseEntity<Pais> GetById(@PathVariable long id){
		return paisRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Pais> cadastroPais(@RequestBody @Valid Pais pais){
		Optional<Pais> paisDuplicado = paisRepository.findByNome(pais.getNome());
		if(paisDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(paisRepository.save(pais));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PAIS JÁ FOI CADASTRADO");
	}

}
