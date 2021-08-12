package com.BlogTeste.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.BlogTeste.model.Tema;
import com.BlogTeste.repositorio.TemaRepositorio;

@RestController
@RequestMapping("/Tema")
@CrossOrigin("*")
public class TemaControlador
{

	
	@Autowired
	private TemaRepositorio repositorio;
	
	
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll()
	{
		return ResponseEntity.status(200).body(repositorio.findAll());
	}

	@GetMapping("/{id}") // buscar apenas pelo id
	public ResponseEntity<Tema> GetById(@PathVariable long id)
	{
		return repositorio.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).build());
	}

	// metodo Post
	@PostMapping("/salvar") // colocando dados na nossa api
	public ResponseEntity<Tema> salvar(@Valid @RequestBody Tema novoTema)
	{
		return ResponseEntity.status(201).body(repositorio.save(novoTema));

	}

	// metodo Put || é escrito da mesma forma que o post
	@PutMapping("/atualizar") //colocando dados na nossa api
		public ResponseEntity<Tema> put (@RequestBody Tema tema){
			return ResponseEntity.status(200).body(repositorio.save(tema));
		}
			
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		repositorio.deleteById(id);
	}
	
}
