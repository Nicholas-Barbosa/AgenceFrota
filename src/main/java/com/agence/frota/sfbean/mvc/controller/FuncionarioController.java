package com.agence.frota.sfbean.mvc.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agence.frota.dto.GenericResponse;
import com.agence.frota.dto.GenericResponse.GenericResponseAttribute;
import com.agence.frota.dto.NovoFuncionarioDTO;
import com.agence.frota.sfbean.aop.annotations.DataIntegrityViolationJoinPoint;
import com.agence.frota.sfbean.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

	private final FuncionarioService service;

	public FuncionarioController(FuncionarioService service) {
		super();
		this.service = service;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@DataIntegrityViolationJoinPoint
	public ResponseEntity<?> save(@RequestBody @Valid NovoFuncionarioDTO object) {
		return ResponseEntity.ok(new GenericResponse(201, "Succesfully created",
				Set.of(new GenericResponseAttribute("ID", service.persist(object)))));
	}

	@DeleteMapping(value = "{id}", produces = "application/json")
	public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
