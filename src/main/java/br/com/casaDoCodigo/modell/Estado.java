package br.com.casaDoCodigo.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estado")
public class Estado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column
	private String nome;
	
	@JsonIgnoreProperties("Pais")
	@ManyToOne
	private Pais pais;
	
	public Estado() {}

	public Estado(Long id, @NotBlank String nome, Pais pais) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	
	

}
