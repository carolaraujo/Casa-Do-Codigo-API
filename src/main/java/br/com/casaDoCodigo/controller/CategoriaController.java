package br.com.casaDoCodigo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.casaDoCodigo.modell.Categoria;
import br.com.casaDoCodigo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public Page<Categoria> listarCategoria(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable paginacaoCat) {
		if (nome == null) {
			return categoriaRepository.findAll(paginacaoCat);
		} else {
			return categoriaRepository.findByNomeContainingIgnoreCase(nome, paginacaoCat);
		}
	}
	
	@PostMapping
	public ResponseEntity<Categoria> cadastrarCatregoria(@RequestBody @Valid Categoria categoria){
		Optional<Categoria> categoriaDuplicado = categoriaRepository.findByNome(categoria.getNome());
		if(categoriaDuplicado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria));
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CATEGORIA JÁ EXISTE NO SISTEMA");
	}
}
