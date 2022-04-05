package com.agence.frota.sfbean.mvc.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
}
