package com.agence.frota.sfbean.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.agence.frota.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

	@Query("FROM Carro c join fetch c.viagens v WHERE v.entrega = null")
	List<Carro> findAllCarrosEmUso();
}
