package br.com.casaDoCodigo.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name ="pagamento")
@GroupSequenceProvider(value = TipoDocGroupProvider.class) // validador de grupos (cpf e cnpj), para filtrar no postman
public class Pagamento {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@NotBlank
	@CPF(groups = Cpf.class)
	@CNPJ(groups = Cnpj.class)
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String tipo;
	
	@NotBlank
	private String telefone;
	
	@NotNull
	@ManyToOne
	private Pais pais;
	
	@NotNull
	@ManyToOne
	private Estado estado;
	
	public Pagamento() {}

	public Pagamento(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String cep, @NotBlank String tipo, @NotBlank String telefone, Pais pais,
			Estado estado) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.cep = cep;
		this.tipo = tipo;
		this.telefone = telefone;
		this.pais = pais;
		this.estado = estado;
	}

	public Long getId() {
		return Id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getCep() {
		return cep;
	}

	public String getTipo() {
		return tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
	
	
}
