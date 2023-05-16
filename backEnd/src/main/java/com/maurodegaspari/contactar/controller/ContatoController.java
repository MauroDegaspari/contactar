package com.maurodegaspari.contactar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.maurodegaspari.contactar.model.ContatoModel;
import com.maurodegaspari.contactar.repository.ContatoRepository;

@RestController //responsável por manipular as requisições REST e produzir as respostas correspondentes. 
@RequestMapping("api/contato") //
public class ContatoController {

	@Autowired
	private ContatoRepository repo;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ContatoModel saveContato(@RequestBody ContatoModel contato){
		 return repo.save(contato);
	}
	
	
	public ContatoModel findContatoId(@PathVariable Long id) {
		return repo
				.findById(id).orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND) );
	}
}
