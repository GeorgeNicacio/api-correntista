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

import com.unp.challenge.domain.Correntista;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CorrentistaRepositoryTest {

	@Autowired
	private CorrentistaRepository repository;
	
	private Correntista correntista; 
	
	
	@Before
	public void setUp() throws Exception {
		correntista = Correntista.builder()
				.id(null)
				.nome("Fulano de Tal")
				.saldoFinanceiro(new BigDecimal(5000))
				.dataCriacao(new Date())
				.build();
	}
	
	@Test
	public void findById() {
		Correntista correntistaDB = repository.findById(1).get();
		Object[] experado = {correntista.getNome()};
		Object[] atual = {correntistaDB.getNome()};
		
		assertArrayEquals(experado, atual);
	}

}
