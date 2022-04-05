package com.agence.frota.sfbean.service;

import com.agence.frota.dto.NovoFuncionarioDTO;

public interface FuncionarioService {

	int persist(NovoFuncionarioDTO transientObject);
}
