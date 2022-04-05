package com.agence.frota.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Carro extends BaseEntity {

	@Column(nullable = false)
	private String modelo;
	@Column(nullable = false)
	private String marca;
	private LocalDate dataFabricacao;

	public Carro() {
		// TODO Auto-generated constructor stub
	}

	public Carro(String modelo, String marca, LocalDate dataFabricacao) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.dataFabricacao = dataFabricacao;
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
