package com.agence.frota.domain;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Carro extends BaseEntity {

	@Column(nullable = false)
	private String modelo;
	@Column(nullable = false)
	private String marca;
	private LocalDate dataFabricacao;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carro", cascade = CascadeType.REMOVE)
	private Set<Viagem> viagens;

	public Carro() {
		// TODO Auto-generated constructor stub
	}

	public Carro(String modelo, String marca, LocalDate dataFabricacao) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
	}

	public Carro(Integer id) {
		// TODO Auto-generated constructor stub
		super.setId(id);
	}

	public String getModelo() {
		return modelo;
	}

	public String getMarca() {
		return marca;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public Set<Viagem> getViagens() {
		return Collections.unmodifiableSet(viagens);
	}

	public void setViagens(Set<Viagem> viagens) {
		this.viagens = new HashSet<>(viagens);
	}

	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", marca=" + marca + ", dataFabricacao=" + dataFabricacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataFabricacao, marca, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		return Objects.equals(dataFabricacao, other.dataFabricacao) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo);
	}

}
