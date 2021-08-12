package com.BlogTeste.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Postagem")
public class Postagem
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Necessaio Titulo")
	@Size(min = 5, max = 100, message = "minimo 5 caracteres maximo 500")
	private String titulo;

	@NotBlank(message = "Necessario Texto")
	@Size(min = 10, max = 500, message = "minimo 10 caracteres maximo 500")
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "minhasPostagens" })
	private Usuario criadore;


	public Tema getTema()
	{
		return tema;
	}

	public void setTema(Tema tema)
	{
		this.tema = tema;
	}

	public Usuario getCriadore()
	{
		return criadore;
	}

	public void setCriadore(Usuario criadore)
	{
		this.criadore = criadore;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public String getTexto()
	{
		return texto;
	}

	public void setTexto(String texto)
	{
		this.texto = texto;
	}

	public Date getData()
	{
		return data;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

}
