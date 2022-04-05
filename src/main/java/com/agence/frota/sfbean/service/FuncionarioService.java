package com.agence.frota.sfbean.service;

import java.util.Set;

import com.agence.frota.dto.FuncionarioDTO;
import com.agence.frota.dto.NovoFuncionarioDTO;

public interface FuncionarioService extends CrudService<NovoFuncionarioDTO, Integer, FuncionarioDTO> {

	int persist(NovoFuncionarioDTO transientObject);

	Set<FuncionarioDTO> findAll();

	void deleteById(Integer id);
}
