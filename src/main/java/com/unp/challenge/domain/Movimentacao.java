package com.unp.challenge.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.unp.challenge.domain.enums.TipoMovimentacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQueries(
		{@NamedStoredProcedureQuery(name="filterMovimentacao",procedureName = "_sp_ListarMovimentacao",resultClasses = Movimentacao.class,
		 parameters = {
				 @StoredProcedureParameter(mode = ParameterMode.IN, name = "dataInicio",type = Date.class),
				 @StoredProcedureParameter(mode = ParameterMode.IN, name = "dataFim",type = Date.class),
				 @StoredProcedureParameter(mode = ParameterMode.IN, name = "tipoMovimentacao",type = String.class)
			}),
		})
public class Movimentacao {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idMovimentacao ")
    private Integer id;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipoMovimentacao ")
	private TipoMovimentacao tipoMovimentacao;
	
	@Column(name="valor ")
	private BigDecimal valor;
	
	@Column(name="dataCriacao ")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@ManyToOne
	@JoinColumn(name="idCorrentista")
	private Correntista correntista;

}
