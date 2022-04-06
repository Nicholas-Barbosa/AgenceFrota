package com.agence.frota.sfbean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agence.frota.domain.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Integer> {

	@Query("FROM Viagem v join fetch v.carro join fetch v.funcionario  where year(v.entrega) = ?1 and month(v.entrega) = ?2")
	List<Viagem> findByYearAndMonth(int year, int month);
}
