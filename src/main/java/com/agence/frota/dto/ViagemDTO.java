package com.agence.frota.dto;

import java.time.LocalDate;

import com.agence.frota.domain.Viagem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "marca", "modelo", "funcionario", "matricula", "retirada", "entrega" })
public class ViagemDTO {

	private String carroModelo, carroMarca, funcionarioNome;
	private Integer funcionarioMatricula;
	private LocalDate retirada, entrega;

	public ViagemDTO(String carroModelo, String carroMarca, String funcionarioNome, Integer funcionarioMatricula,
			LocalDate retirada, LocalDate entrega) {
		super();
		this.carroModelo = carroModelo;
		this.carroMarca = carroMarca;
		this.funcionarioNome = funcionarioNome;
		this.funcionarioMatricula = funcionarioMatricula;
		this.retirada = retirada;
		this.entrega = entrega;
	}

	@JsonProperty("modelo")
	public String getCarroModelo() {
		return carroModelo;
	}

	@JsonProperty("marca")
	public String getCarroMarca() {
		return carroMarca;
	}

	@JsonProperty("funcionario")
	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	@JsonProperty("matricula")
	public Integer getFuncionarioMatricula() {
		return funcionarioMatricula;
	}

	public LocalDate getRetirada() {
		return retirada;
	}

	public LocalDate getEntrega() {
		return entrega;
	}

	public static ViagemDTO fromDomain(Viagem viagem) {
		// Principio OO, talk only to your friends
		return new ViagemDTO(viagem.getCarroModelo(), viagem.getCarroMarca(), viagem.getFuncionarioNome(),
				viagem.getFuncionarioMatricula(), viagem.getRetirada(), viagem.getEntrega());
	}
}
