package co.edu.unbosque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.enums.RolNombre;
import co.edu.unbosque.service.RolService;

@Service
public class CrearRoles implements CommandLineRunner{
	
	@Autowired
	RolService rolService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		/*
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		rolService.save(rolUser);
		rolService.save(rolAdmin);
		*/
		
		//System.out.println(passwordEncoder.encode("123"));
		
		
	}
	
	

}
