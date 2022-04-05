package com.agence.frota.dto;

import java.util.Objects;

import com.agence.frota.domain.Funcionario;

public class FuncionarioDTO {

	private String nome;
	private Integer matricula;

	public FuncionarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public FuncionarioDTO(String nome, Integer matricula) {
		super();
		this.nome = nome;
		this.matricula = matricula;
	}

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

	public static FuncionarioDTO fromDomain(Funcionario domain) {
		return new FuncionarioDTO(domain.getNome(), domain.getMatricula());
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FuncionarioDTO other = (FuncionarioDTO) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return "FuncionarioDTO [nome=" + nome + ", matricula=" + matricula + "]";
	}

}
