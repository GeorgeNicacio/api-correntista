package com.unp.challenge.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Correntista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idCorrentista")
	private Integer id;
	
	@NotNull
	@Column(name="nome")
	private String nome;
	
	@Column(name="dataCriacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;
	
	@Column(name="saldoFinanceiro")
	private BigDecimal saldoFinanceiro;

}
