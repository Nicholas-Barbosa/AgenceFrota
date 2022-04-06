package com.agence.frota.sfbean.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.agence.frota.domain.Carro;
import com.agence.frota.domain.Funcionario;
import com.agence.frota.domain.Viagem;
import com.agence.frota.dto.NovaViagemDTO;
import com.agence.frota.dto.ViagemDTO;
import com.agence.frota.sfbean.repository.CarroRepository;
import com.agence.frota.sfbean.repository.FuncionarioRepository;
import com.agence.frota.sfbean.repository.ViagemRepository;

@Service
public class ViagemServiceImpl implements ViagemService {

	private final ViagemRepository repository;
	private final CarroRepository carroRepository;
	private final FuncionarioRepository funcionarioRepository;

	public ViagemServiceImpl(ViagemRepository repository, CarroRepository carroRepository,
			FuncionarioRepository funcionarioRepository) {
		super();
		this.repository = repository;
		this.carroRepository = carroRepository;
		this.funcionarioRepository = funcionarioRepository;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public int persist(NovaViagemDTO dto) {
		// TODO Auto-generated method stub
		Optional<? extends Object>[] optionalObjects = getObjects(dto.getCarId(), dto.getFuncionarioId());
		Optional<Carro> maybeCar = (Optional<Carro>) optionalObjects[0];
		Optional<Funcionario> maybeFunc = (Optional<Funcionario>) optionalObjects[1];
		Viagem transientObject = new Viagem(maybeCar.orElseThrow(), LocalDate.now(), null, maybeFunc.orElseThrow());
		return repository.save(transientObject).getId();
	}

	private Optional<? extends Object>[] getObjects(int carId, int funId) {
		ExecutorService executor = null;
		try {
			executor = Executors.newFixedThreadPool(2);
			Callable<Optional<Carro>> callCar = () -> carroRepository.findById(carId);
			Callable<Optional<Funcionario>> callFunc = () -> funcionarioRepository.findById(funId);
			Future<Optional<Carro>> submit = executor.submit(callCar);
			Future<Optional<Funcionario>> submit2 = executor.submit(callFunc);
			return new Optional<?>[] { submit.get(), submit2.get() };
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return null;
		} finally {
			executor.shutdown();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void devolucao(int viagemId) {
		repository.findById(viagemId).ifPresent(v -> v.setEntrega(LocalDate.now()));

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ViagemDTO> findAllPerMounthYear(int year, int month) {
		// TODO Auto-generated method stub
		return repository.findByYearAndMonth(year,month).parallelStream().map(ViagemDTO::fromDomain)
				.collect(CopyOnWriteArrayList::new, List::add, List::addAll);
	}
}
