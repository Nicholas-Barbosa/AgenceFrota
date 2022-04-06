package com.agence.frota.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Funcionario extends BaseEntity {

	@Column(nullable = false)
	private String nome;
	@Column(unique = true, nullable = false)
	private Integer matricula;

	public Funcionario() {
		// TODO Auto-generated constructor stub
	}

	public Funcionario(Integer id) {
		super.setId(id);
	}

	public Funcionario(String nome, Integer matricula) {
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

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", matricula=" + matricula + "]";
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
		Funcionario other = (Funcionario) obj;
		return Objects.equals(matricula, other.matricula);
	}

}
