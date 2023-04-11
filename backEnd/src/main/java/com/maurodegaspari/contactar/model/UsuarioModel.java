package com.maurodegaspari.contactar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class UsuarioModel {
	
	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue()
	private Integer id;
	
	@Column(name = "NOMEUSUARIO")
	private String nome_usuario;
	
	@Column(name = "SENHA")
	private String senha;
	
	

	public UsuarioModel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
