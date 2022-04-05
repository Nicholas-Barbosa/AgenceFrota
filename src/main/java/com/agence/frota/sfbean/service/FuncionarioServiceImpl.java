package com.agence.frota.sfbean.service;

import org.springframework.stereotype.Service;

import com.agence.frota.domain.Funcionario;
import com.agence.frota.dto.NovoFuncionarioDTO;
import com.agence.frota.sfbean.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private final FuncionarioRepository repository;

	public FuncionarioServiceImpl(FuncionarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public int persist(NovoFuncionarioDTO transientObject) {
		Funcionario managedObject = repository.save(transientObject.toDomain());
		return managedObject.getId();
	}

}
