package com.agence.frota.domain;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Viagem extends BaseEntity {

	@ManyToOne
	private Carro carro;
	@Column(nullable = false)
	private LocalDate retirada, entrega;

	public Viagem(Carro carro, LocalDate retirada, LocalDate entrega) {
		super();
		this.carro = carro;
		this.retirada = retirada;
		this.entrega = entrega;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public LocalDate getRetirada() {
		return retirada;
	}

	public void setRetirada(LocalDate retirada) {
		this.retirada = retirada;
	}

	public LocalDate getEntrega() {
		return entrega;
	}

	public void setEntrega(LocalDate entrega) {
		this.entrega = entrega;
	}

	@Override
	public String toString() {
		return "Viagem [carro=" + carro + ", retirada=" + retirada + ", entrega=" + entrega + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carro, entrega, retirada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		return Objects.equals(carro, other.carro) && Objects.equals(entrega, other.entrega)
				&& Objects.equals(retirada, other.retirada);
	}

}
