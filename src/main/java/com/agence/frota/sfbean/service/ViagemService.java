package com.agence.frota.sfbean.service;

import java.util.List;

import com.agence.frota.dto.NovaViagemDTO;
import com.agence.frota.dto.ViagemDTO;

public interface ViagemService {

	int persist(NovaViagemDTO dto);
	
	void devolucao(int viagemId);
	
	List<ViagemDTO>findAllPerMounthYear(int mount,int year);
}
