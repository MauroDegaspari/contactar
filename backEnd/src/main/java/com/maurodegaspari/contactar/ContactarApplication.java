package com.maurodegaspari.contactar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maurodegaspari.contactar.model.ContatoModel;
import com.maurodegaspari.contactar.model.UsuarioModel;
import com.maurodegaspari.contactar.repository.ContatoRepository;
import com.maurodegaspari.contactar.repository.UsuarioRepository;

@SpringBootApplication
public class ContactarApplication implements CommandLineRunner {

	@Autowired //injeção de dependência automaticamente
	private UsuarioRepository UsuarioRepo;
	@Autowired
	private ContatoRepository ContatoRepo;
	
	public static void main(String[] args) {
		
		SpringApplication.run(ContactarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		UsuarioModel usuario = new UsuarioModel();
		ContatoModel contato = new ContatoModel();
		
		
		
		
		usuario.setId(1);
		usuario.setNome_usuario("Mauro");
		usuario.setSenha("123");
		contato.setId(1);
		contato.setNomeContato("Larissa");
		contato.setAnotacao("teste anotação tomCat");
		contato.setEmail("tomcat@email.com");
		contato.setFone("123234234-87");
		contato.setUsuario(usuario);
		
		
		
		UsuarioRepo.save(usuario);
		ContatoRepo.save(contato);
	}

}
