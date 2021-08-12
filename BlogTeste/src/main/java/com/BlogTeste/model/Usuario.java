package com.BlogTeste.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "Usuario")
public class Usuario
{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "Obrigatorio nome ")
	@Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500")
	private String nome;
	
	
	@Email(message = "Obrigatorio email")
	@Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500")
	private String email;
	
	
	@NotBlank(message = "Obrigatorio senha")
	@Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500")
	private String senha;
	
	@OneToMany(mappedBy = "criadore", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"criadore"})
	private List<Postagem> minhasPostagens = new ArrayList<>();



	public Usuario()
	{
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(Long id,
			@NotBlank(message = "Obrigatorio nome ") @Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500") String nome,
			@Email(message = "Obrigatorio Email") @Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500") String email,
			@NotBlank(message = "Obrigatorio senha") @Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500") String senha,
			List<Postagem> minhasPostagens)
	{
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.minhasPostagens = minhasPostagens;
	}


	public Long getId()
	{
		return id;
	}


	public void setId(Long id)
	{
		this.id = id;
	}


	public List<Postagem> getMinhasPostagens()
	{
		return minhasPostagens;
	}


	public void setMinhasPostagens(List<Postagem> minhasPostagens)
	{
		this.minhasPostagens = minhasPostagens;
	}


	public String getNome()
	{
		return nome;
	}


	public void setNome(String nome)
	{
		this.nome = nome;
	}


	public String getEmail()
	{
		return email;
	}


	public void setEmail(String email)
	{
		this.email = email;
	}


	public String getSenha()
	{
		return senha;
	}


	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	
}
