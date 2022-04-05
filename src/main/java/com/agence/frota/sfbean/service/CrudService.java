package com.agence.frota.sfbean.service;

import java.util.Set;

public interface CrudService<P, ID, L> {

	int persist(P nw);

	void deleteById(ID id);

	Set<L> findAll();
}
