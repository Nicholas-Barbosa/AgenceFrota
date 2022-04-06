package com.agence.frota.sfbean.mvc.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agence.frota.dto.GenericResponse;
import com.agence.frota.dto.GenericResponse.GenericResponseAttribute;
import com.agence.frota.dto.NovaViagemDTO;
import com.agence.frota.sfbean.service.ViagemService;

@RestController
@RequestMapping("/viagem")
public class ViagemController {

	private final ViagemService service;

	public ViagemController(ViagemService service) {
		super();
		this.service = service;
	}

	@PostMapping(value = "/{idFuncionario}/{idCarro}")
	public ResponseEntity<?> save(@PathVariable("idFuncionario") int idFuncionario,
			@PathVariable("idCarro") int idCar) {
		NovaViagemDTO object = new NovaViagemDTO();
		object.setCarId(idCar);
		object.setFuncionarioId(idFuncionario);
		return ResponseEntity.ok(new GenericResponse(201, "Succesfully created",
				Set.of(new GenericResponseAttribute("ID", service.persist(object)))));
	}

	@DeleteMapping(value = "/{idViagem}")
	public ResponseEntity<?> devolucao(@PathVariable("idViagem") int idViagem) {
		service.devolucao(idViagem);
		return ResponseEntity.ok().build();

	}

	@GetMapping(value = "/{mes}/{ano}")
	public ResponseEntity<?> findAllPerMounthYear(@PathVariable("mes") int mes, @PathVariable("ano") int ano) {
		return ResponseEntity.ok(service.findAllPerMounthYear(ano, mes));

	}
}
