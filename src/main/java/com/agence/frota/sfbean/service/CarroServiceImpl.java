package com.agence.frota.sfbean.service;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.agence.frota.dto.CarroDTO;
import com.agence.frota.sfbean.repository.CarroRepository;

@Service
public class CarroServiceImpl implements CarroService {

	private final CarroRepository repository;

	public CarroServiceImpl(CarroRepository repository) {
		super();
		this.repository = repository;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int persist(CarroDTO transientObj) {
		return repository.save(transientObj.toDomain()).getId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);

	}

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
	@Override
	public Set<CarroDTO> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll().parallelStream().map(CarroDTO::fromDomain).collect(ConcurrentSkipListSet::new,
				Set::add, Set::addAll);
	}

	@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
	@Override
	public Set<CarroDTO> findAllEmUso() {
		// TODO Auto-generated method stub
		return repository.findAllCarrosEmUso().parallelStream().map(CarroDTO::fromDomain)
				.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
	}

}
