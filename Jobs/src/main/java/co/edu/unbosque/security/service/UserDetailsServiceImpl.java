package co.edu.unbosque.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.UsuarioService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioService.getByEmail(email).orElseThrow(()-> new UsernameNotFoundException(email));
		return UsuarioPrincipal.build(usuario);
	}
	
	

}
