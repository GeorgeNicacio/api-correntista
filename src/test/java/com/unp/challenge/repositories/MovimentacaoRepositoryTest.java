package com.unp.challenge.repositories;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.unp.challenge.domain.Movimentacao;
import com.unp.challenge.domain.enums.TipoMovimentacao;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MovimentacaoRepositoryTest {

	@Autowired
	private MovimentacaoRepository repository;
	
	private Movimentacao movimentacaoDebito; 
	private Movimentacao movimentacaoCredito;
	
	
	@Before
	public void setUp() throws Exception {
		movimentacaoDebito = Movimentacao.builder()
				.id(null)
				.tipoMovimentacao(TipoMovimentacao.DEBITO)
				.valor(new BigDecimal(5000))
				.dataCriacao(new Date())
				.build();
		
		movimentacaoCredito = Movimentacao.builder()
				.id(null)
				.tipoMovimentacao(TipoMovimentacao.CREDITO)
				.valor(new BigDecimal(2000))
				.dataCriacao(new Date())
				.build();
		
	}
	
	@Test
	public void findById() {
		Movimentacao movimentacaoDB = repository.findById(1).get();
		Object[] experado = {movimentacaoDebito.getTipoMovimentacao(), movimentacaoDebito.getValor()};
		Object[] atual = {movimentacaoDB.getTipoMovimentacao(), movimentacaoDB.getValor()};
		
		assertArrayEquals(experado, atual);
	}

}
