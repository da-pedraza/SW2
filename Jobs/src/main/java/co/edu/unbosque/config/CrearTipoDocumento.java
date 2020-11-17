package co.edu.unbosque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.TipoDocumento;
import co.edu.unbosque.service.TipoDocumentoService;

@Service
public class CrearTipoDocumento implements CommandLineRunner{

	@Autowired
	TipoDocumentoService tipoDocumentoService;

	@Override
	public void run(String... args) throws Exception {
		
		/*
		TipoDocumento cc = new TipoDocumento("C.C");
		TipoDocumento ce = new TipoDocumento("C.E");
		tipoDocumentoService.save(cc);
		tipoDocumentoService.save(ce);
		*/
	}
	
	
	
}
