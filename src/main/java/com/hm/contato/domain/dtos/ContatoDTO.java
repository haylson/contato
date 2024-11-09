package com.hm.contato.domain.dtos;

import java.io.Serializable;

import com.hm.contato.domain.Contato;

import jakarta.validation.constraints.NotNull;



public class ContatoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull(message = "O campo NOME é obrigatório.")
	private String nome;
	
	@NotNull(message = "O campo SOBRENOME é obrigatório.")
	private String sobrenome;
	
	@NotNull(message = "O campo CPF é obrigatório.")
	private String cpf;
	
	@NotNull(message = "O campo EMAIL é obrigatório.")
	private String email;
	
	public ContatoDTO() {
		super();
	}

	public ContatoDTO(Contato obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.sobrenome = obj.getSobrenome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
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
	
	

}
