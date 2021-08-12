package com.BlogTeste.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlogTeste.model.Postagem;

@Repository
public interface PostagemRepositorio extends JpaRepository<Postagem, Long>
{
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
