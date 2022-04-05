package com.agence.frota.sfbean.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.agence.frota.dto.CarroDTO;
import com.agence.frota.sfbean.repository.CarroRepository;

@Service
public class CarroServiceImpl implements CarroService {

	private final CarroRepository repository;

	public CarroServiceImpl(CarroRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public int persist(CarroDTO transientObj) {
		return repository.save(transientObj.toDomain()).getId();
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public Set<CarroDTO> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll().stream().map(CarroDTO::fromDomain).collect(Collectors.toSet());
	}

	@Override
	public Set<CarroDTO> retirados() {
		// TODO Auto-generated method stub
		return null;
	}

}
