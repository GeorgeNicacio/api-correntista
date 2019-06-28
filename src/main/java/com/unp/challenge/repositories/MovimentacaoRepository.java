package com.unp.challenge.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unp.challenge.domain.Movimentacao;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
	
	@Procedure(name = "filterMovimentacao")
	Page<Movimentacao> search(@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim,
							  @Param("tipoMovimentacao") String tipoMovimentacao,Pageable pageRequest);

}
