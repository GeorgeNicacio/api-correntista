package com.unp.challenge.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unp.challenge.domain.Movimentacao;


@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{
	
	@Query(value = "EXECUTE _sp_ListarMovimentacao :dataInicio, :dataFim, :tipoMovimentacao ", nativeQuery = true)
	List<Movimentacao> search(@Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim,
							  @Param("tipoMovimentacao") String tipoMovimentacao);

}
