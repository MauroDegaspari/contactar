package com.maurodegaspari.contactar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.maurodegaspari.contactar.model.UsuarioModel;
import com.maurodegaspari.contactar.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository repo;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioModel salvarUser(@RequestBody UsuarioModel user) {
		return repo.save(user);
	}
	
	@GetMapping("{id}")
	public UsuarioModel findClienteId(@PathVariable Long id) {
		return repo
				.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/todos")
	public List<UsuarioModel> todosClientesFind(Pageable pageable){
		return repo.findAll();
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirCLiente(@PathVariable Long id) {
		repo
		.findById(id)
		.map( cliente ->{
			repo.delete(cliente);
			return Void.TYPE;
		})
		.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado) {
		repo
		    .findById(id)
		    .map( usuario ->{
		    	usuario.setNome_usuario(usuarioAtualizado.getNome_usuario());
		    	usuario.setSenha(usuarioAtualizado.getSenha());
		    	return repo.save(usuario);
		    })
		    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT));
	}
}
