package com.agence.frota.sfbean.service;

import java.util.Set;

import com.agence.frota.dto.CarroDTO;

public interface CarroService extends CrudService<CarroDTO, Integer, CarroDTO> {

	Set<CarroDTO> retirados();
}
