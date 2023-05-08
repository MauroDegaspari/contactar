package com.maurodegaspari.contactar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maurodegaspari.contactar.model.ContatoModel;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, Long>{

}
