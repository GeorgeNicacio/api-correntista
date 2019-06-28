package com.unp.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unp.challenge.domain.Correntista;


public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
