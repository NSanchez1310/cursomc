package com.nsanchez1310.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsanchez1310.cursomc.domain.Cidade;
import com.nsanchez1310.cursomc.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}

}
