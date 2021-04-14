package br.com.casaDoCodigo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.casaDoCodigo.modell.Autor;
import br.com.casaDoCodigo.repository.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;
	
	@GetMapping
	public ResponseEntity<List<Autor>> getAll(){
		return ResponseEntity.ok(autorRepository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Autor> cadastrarAutor(@RequestBody @Valid Autor autor){
		Optional<Autor> emailDuplicado = autorRepository.findByEmail(autor.getEmail());
		if(emailDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(autorRepository.save(autor));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "EMAIL JÁ EXISTENTE NO SISTEMA");
	}
}
