package co.edu.unbosque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.service.CiudadService;

@Service
public class CrearCiudades implements CommandLineRunner {

	@Autowired
	CiudadService ciudadService;

	@Override
	public void run(String... args) throws Exception {
		/*Ciudad bogota = new Ciudad("Bogota");
		Ciudad medellin = new Ciudad("Medellin");
		Ciudad cali = new Ciudad("Cali");
		Ciudad barranquilla = new Ciudad("Barranquila");
		Ciudad bucaramanga = new Ciudad("Bucaramanga");
		ciudadService.save(bogota);
		ciudadService.save(medellin);
		ciudadService.save(cali);
		ciudadService.save(barranquilla);
		ciudadService.save(bucaramanga);*/
		
	}
	
	
	
}
