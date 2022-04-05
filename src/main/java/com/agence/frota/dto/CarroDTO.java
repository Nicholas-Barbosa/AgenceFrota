package com.agence.frota.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.agence.frota.domain.Carro;

public class CarroDTO {

	private String modelo, marca;
	private LocalDate fabricacao;

	public CarroDTO() {
		// TODO Auto-generated constructor stub
	}

	public CarroDTO(String modelo, String marca, LocalDate fabricacao) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.fabricacao = fabricacao;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public LocalDate getFabricacao() {
		return fabricacao;
	}

	public void setFabricacao(LocalDate fabricacao) {
		this.fabricacao = fabricacao;
	}

	public static CarroDTO fromDomain(Carro carro) {
		return new CarroDTO(carro.getModelo(), carro.getMarca(), carro.getDataFabricacao());
	}
	
	public Carro toDomain() {
		return new Carro(modelo, marca, fabricacao);
	}

	@Override
	public int hashCode() {
		return Objects.hash(fabricacao, marca, modelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarroDTO other = (CarroDTO) obj;
		return Objects.equals(fabricacao, other.fabricacao) && Objects.equals(marca, other.marca)
				&& Objects.equals(modelo, other.modelo);
	}

	@Override
	public String toString() {
		return "NovoCarroDTO [modelo=" + modelo + ", marca=" + marca + ", fabricacao=" + fabricacao + "]";
	}

}
