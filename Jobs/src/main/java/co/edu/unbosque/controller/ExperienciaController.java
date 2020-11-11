package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.dao.ExperienciaDTO;
import co.edu.unbosque.dao.Mensaje;
import co.edu.unbosque.entity.Experiencia;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.ExperienciaService;
import co.edu.unbosque.service.UsuarioService;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	ExperienciaService experienciaService;

	@PostMapping("/create/{email}")
	public ResponseEntity<?> create(@PathVariable("email") String email, @RequestBody ExperienciaDTO experienciaDTO) {
		if (!usuarioService.existsByEmail(email)) {
			return new ResponseEntity(new Mensaje("El email no se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = usuarioService.getByEmail(email).get();
		List<Experiencia> lexp = usuario.getExperiencia();
		Experiencia exp = new Experiencia();
		exp.setCargo(experienciaDTO.getCargo());
		exp.setCiudad(experienciaDTO.getCiudad());
		exp.setEmpresa(experienciaDTO.getEmpresa());
		exp.setFunciones(experienciaDTO.getFunciones());
		exp.setfInicio(experienciaDTO.getF_inicio());
		exp.setfFin(experienciaDTO.getF_fin());
		exp.setUsuario(usuario);
		lexp.add(exp);
		usuario.setExperiencia(lexp);
		experienciaService.save(exp);

		return new ResponseEntity(new Mensaje("Experiencia agregada correctamente"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!experienciaService.existsById(id)) {
			return new ResponseEntity(new Mensaje("El id no se encuentra registrado"), HttpStatus.BAD_REQUEST);			
		}
		experienciaService.delete(id);
		return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
	}

}
