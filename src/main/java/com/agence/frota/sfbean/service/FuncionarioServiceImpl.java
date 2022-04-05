package com.agence.frota.sfbean.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.agence.frota.domain.Funcionario;
import com.agence.frota.dto.FuncionarioDTO;
import com.agence.frota.dto.NovoFuncionarioDTO;
import com.agence.frota.sfbean.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	private final FuncionarioRepository repository;

//	@PersistenceContext
//	private EntityManager em;

	public FuncionarioServiceImpl(FuncionarioRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int persist(NovoFuncionarioDTO transientObject) {
		Funcionario managedObject = repository.save(transientObject.toDomain());
		return managedObject.getId();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Set<FuncionarioDTO> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll().stream().map(FuncionarioDTO::fromDomain).collect(Collectors.toSet());
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}
