package com.BlogTeste.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.BlogTeste.model.Usuario;
import com.BlogTeste.repositorio.UsuarioRepositorio;

@Service
public class UserDetailServiceImpl implements UserDetailsService
{

	@Autowired
	private UsuarioRepositorio userRepositorio;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Optional<Usuario>user = userRepositorio.findByEmail(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "Not Found"));
		
		return user.map(UserDatailsImpl::new).get();
	}
}
