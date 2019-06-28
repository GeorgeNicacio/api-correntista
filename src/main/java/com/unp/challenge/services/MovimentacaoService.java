package com.unp.challenge.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unp.challenge.domain.Movimentacao;
import com.unp.challenge.repositories.MovimentacaoRepository;
import com.unp.challenge.services.exceptions.DataIntegrityException;
import com.unp.challenge.services.exceptions.ObjectNotFoundException;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repo;
	
	public Movimentacao find(Integer id) {
		
		Optional<Movimentacao> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Movimentacao.class.getName()));
	}
	
	@Transactional
	public Movimentacao insert(Movimentacao obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Movimentacao update(Movimentacao obj) {
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pessoa relacionada");
		}
	}
	
	public Page<Movimentacao> search(Date dataInicio, Date dataFim, String tipoMovimentacao, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.search(dataInicio, dataFim, tipoMovimentacao, pageRequest);
	}
	
}
