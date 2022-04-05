package com.agence.frota.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.agence.frota.domain.Funcionario;

public class NovoFuncionarioDTO {

	@NotBlank
	private String nome;
	@NotNull
	private Integer matricula;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Funcionario toDomain() {
		return new Funcionario(nome, matricula);
	}
}
