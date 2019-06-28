package com.unp.challenge.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unp.challenge.domain.Correntista;
import com.unp.challenge.repositories.CorrentistaRepository;
import com.unp.challenge.services.exceptions.DataIntegrityException;
import com.unp.challenge.services.exceptions.ObjectNotFoundException;

@Service
public class CorrentistaService {
	
	@Autowired
	private CorrentistaRepository repo;
	
	public Correntista find(Integer id) {
		
		Optional<Correntista> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Correntista.class.getName()));
	}
	
	@Transactional
	public Correntista insert(Correntista obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}
	
	public Correntista update(Correntista obj) {
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
	
	
}
