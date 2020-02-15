package com.nsanchez1310.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nsanchez1310.cursomc.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> { 
	
	// Busca se já existe o email na base
	@Transactional(readOnly=true)
	Cliente findByEmail(String email);

}
