package co.edu.unbosque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.EstadoCivil;
import co.edu.unbosque.service.EstadoCivilService;

@Service
public class CrearEstadoCivil implements CommandLineRunner {

	@Autowired
	EstadoCivilService estadoCivilService;

	@Override
	public void run(String... args) throws Exception {

		/*
		EstadoCivil casado = new EstadoCivil("Casado");
		EstadoCivil soltero = new EstadoCivil("Soltero");
		estadoCivilService.save(soltero);
		estadoCivilService.save(casado);
		 */
	}

}
