package com.hm.contato.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.hm.contato.domain.dtos.ContatoDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Contato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O campo não pode ser vazio")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(max = 100, message = "Tamanho máximo de 100 caracteres")
	private String nome;
	
	@NotNull(message = "O campo não pode ser vazio")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(max = 100, message = "Tamanho máximo de 100 caracteres")
	private String sobrenome;
	
	//@CPF
	//@Column(unique = true)
	@NotNull(message = "O campo não pode ser vazio")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(max = 11, message = "CPF deve possuir 11 caracteres")
	private String cpf;
	
	//@Column(unique = true)
	@NotNull(message = "O campo não pode ser vazio")
	@NotBlank(message = "O campo não pode ser em branco")
	@Size(max = 100, message = "Tamanho máximo de 100 caracteres")
	private String email;
	
	@OneToMany(mappedBy = "contato", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	
	public Contato() {
		super();
	}
	
	public Contato(ContatoDTO contatoDTO) {
		super();
		this.id = contatoDTO.getId();
		this.nome = contatoDTO.getNome();
		this.sobrenome = contatoDTO.getSobrenome();
		this.cpf = contatoDTO.getCpf();
		this.email = contatoDTO.getEmail();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobreNome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	 
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
}
