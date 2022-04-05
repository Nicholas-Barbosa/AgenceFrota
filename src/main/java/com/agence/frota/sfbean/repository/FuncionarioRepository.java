package com.agence.frota.sfbean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agence.frota.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
