package com.BlogTeste.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BlogTeste.model.Tema;



@Repository
public interface TemaRepositorio  extends JpaRepository<Tema, Long>
{
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}

