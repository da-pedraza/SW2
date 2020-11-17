package co.edu.unbosque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.Genero;
import co.edu.unbosque.service.GeneroService;

@Service
public class CrearGeneros implements CommandLineRunner {

	@Autowired
	GeneroService generoService;

	@Override
	public void run(String... args) throws Exception {

		/*
		Genero masculino = new Genero("Masculino");
		Genero femenino = new Genero("Femenino");
		generoService.save(masculino);
		generoService.save(femenino);
		*/

	}

}
