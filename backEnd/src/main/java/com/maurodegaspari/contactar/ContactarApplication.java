package com.maurodegaspari.contactar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maurodegaspari.contactar.model.UsuarioModel;
import com.maurodegaspari.contactar.repository.UsuarioRepository;

@SpringBootApplication
public class ContactarApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repo;
	
	public static void main(String[] args) {
		
		SpringApplication.run(ContactarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		UsuarioModel usuario = new UsuarioModel();
		
		usuario.setId(12);
		usuario.setNome_usuario("Mauro");
		usuario.setSenha("123");
		
		repo.save(usuario);
	}

}
