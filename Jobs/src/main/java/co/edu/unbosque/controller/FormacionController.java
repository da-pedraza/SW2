package co.edu.unbosque.controller;

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
import co.edu.unbosque.dao.FormacionDTO;
import co.edu.unbosque.dao.Mensaje;
import co.edu.unbosque.entity.Formacion;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.FormacionService;
import co.edu.unbosque.service.UsuarioService;

@RestController
@RequestMapping("/formacion")
@CrossOrigin(origins = "*")
public class FormacionController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	FormacionService formacionService;
	
	@PostMapping("/create/{email}")
	public ResponseEntity<?> create(@PathVariable("email") String email, @RequestBody FormacionDTO formacionDTO) {
		if (!usuarioService.existsByEmail(email)) {
			return new ResponseEntity(new Mensaje("El email no se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = usuarioService.getByEmail(email).get();
		List<Formacion> listaFormacion = usuario.getFormacion();
		Formacion formacion = new Formacion();
		formacion.setUsuario(usuario);
		formacion.setInstitucion(formacionDTO.getInstitucion());
		formacion.setNivelFormacion(formacionDTO.getNivelFormacion());
		formacion.setEstadoFormacion(formacionDTO.getEstadoFormacion());
		formacion.setF_inicio(formacionDTO.getF_inicio());
		formacion.setF_fin(formacionDTO.getF_fin());
		listaFormacion.add(formacion);
		usuario.setFormacion(listaFormacion);
		formacionService.save(formacion);

		return new ResponseEntity(new Mensaje("Formacion agregada correctamente"), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		if(!formacionService.existsById(id)) {
			return new ResponseEntity(new Mensaje("El id no se encuentra registrado"), HttpStatus.BAD_REQUEST);			
		}
		formacionService.delete(id);
		return new ResponseEntity(new Mensaje("Formacion eliminada"), HttpStatus.OK);
	}

}
