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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BlogTeste.model.Postagem;
import com.BlogTeste.repositorio.PostagemRepositorio;

@RestController
@RequestMapping("/Postagem")
@CrossOrigin("*")
public class PostagemControlador
{
	@Autowired
	private PostagemRepositorio repositorio;

	@GetMapping
	public ResponseEntity<List<Postagem>> GetAll()
	{
		return ResponseEntity.status(200).body(repositorio.findAll());
	}

	@GetMapping("/{id}") // buscar apenas pelo id
	public ResponseEntity<Postagem> GetById(@PathVariable long id)
	{
		return repositorio.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElse(ResponseEntity.status(404).build());
	}

	// metodo Post
	@PostMapping("/salvar") // colocando dados na nossa api
	public ResponseEntity<Postagem> salvar(@Valid @RequestBody Postagem novaPostagem)
	{
		return ResponseEntity.status(201).body(repositorio.save(novaPostagem));

	}

	// metodo Put || é escrito da mesma forma que o post
//		@PutMapping("/atualizar") //colocando dados na nossa api
//		public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
//			return ResponseEntity.status(200).body(repositorio.save(postagem));
//		}
//			
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		repositorio.deleteById(id);
	}
}
