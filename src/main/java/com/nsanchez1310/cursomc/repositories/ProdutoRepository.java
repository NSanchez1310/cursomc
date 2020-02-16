package com.nsanchez1310.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nsanchez1310.cursomc.domain.Categoria;
import com.nsanchez1310.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> { 
	
	@Transactional(readOnly=true)	
// Duas alternativas para acesso: 1)	
//	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
//	Page<Produto> search(@Param ("nome")  String nome, @Param ("categorias") List<Categoria> categorias, Pageable pageRequest);
//  Alternativa 2:
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);

}
