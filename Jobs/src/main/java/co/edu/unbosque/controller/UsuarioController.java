package co.edu.unbosque.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.dao.DatosPersonalesDTO;
import co.edu.unbosque.dao.Mensaje;
import co.edu.unbosque.dao.UsuarioDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.DatosPersonales;
import co.edu.unbosque.entity.EstadoCivil;
import co.edu.unbosque.entity.Genero;
import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.entity.TipoDocumento;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.enums.RolNombre;
import co.edu.unbosque.service.DatosPersonalesService;
import co.edu.unbosque.service.RolService;
import co.edu.unbosque.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	DatosPersonalesService datosPersonalesService;
	
	@Autowired
	RolService RolService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/lista")
	public ResponseEntity<List<Usuario>> list() {
		List<Usuario> list = usuarioService.list();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable("id") int id) {
		if (!usuarioService.existsById(id)) {
			return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.NOT_FOUND);
		} else {
			Usuario usuario = usuarioService.getOne(id).get();
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	}

	@GetMapping("/detailemail/{email}")
	public ResponseEntity<Usuario> getByEmail(@PathVariable("email") String email) {
		if (!usuarioService.existsByEmail(email)) {
			return new ResponseEntity(new Mensaje("El email no existe"), HttpStatus.NOT_FOUND);
		} else {
			Usuario usuario = usuarioService.getByEmail(email).get();
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
	}

	@PostMapping("/registrar")
	public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {
		if (usuarioService.existsByEmail(usuarioDTO.getEmail())) {
			return new ResponseEntity(new Mensaje("El email ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}

		if (datosPersonalesService.existsByNumDocumento(usuarioDTO.getNum_Documento())) {
			return new ResponseEntity(new Mensaje("El id ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}

		TipoDocumento td = new TipoDocumento();
		td.setId(usuarioDTO.getT_Documento());
		Ciudad ciudad = new Ciudad();
		ciudad.setId(usuarioDTO.getCiudadResidencia());
		EstadoCivil ec = new EstadoCivil();
		ec.setId(usuarioDTO.getEstadoCivil());
		Genero genero = new Genero();
		genero.setId(usuarioDTO.getGenero());
		DatosPersonales dp = new DatosPersonales(td, usuarioDTO.getNum_Documento(),
				usuarioDTO.getP_Nombre(), usuarioDTO.getS_Nombre(), usuarioDTO.getP_Apellido(),
				usuarioDTO.getS_Apellido(), usuarioDTO.getF_Nacimiento(), genero,
				ec, ciudad, usuarioDTO.getTelefono());
		Usuario usuario = new Usuario(usuarioDTO.getEmail(), passwordEncoder.encode(usuarioDTO.getPassword()), dp);
		Rol rolUser = RolService.getByRolNombre(RolNombre.ROLE_USER).get();
		Set<Rol> roles = new HashSet<>();
		roles.add(rolUser);
		usuario.setRol(roles);
		dp.setUsuario(usuario);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario creado exitosamente"), HttpStatus.OK);
	}

	@PutMapping("/update/{email}")
	public ResponseEntity<?> update(@PathVariable("email") String email, @RequestBody UsuarioDTO usuarioDTO) {

		if (!usuarioService.existsByEmail(email)) {
			return new ResponseEntity(new Mensaje("El email no se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}

		if (usuarioService.existsByEmail(usuarioDTO.getEmail())) {
			return new ResponseEntity(new Mensaje("El email ya se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}

		Usuario usuario = usuarioService.getByEmail(email).get();
		usuario.setEmail(usuarioDTO.getEmail());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Usuario actualizado exitosamente"), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{email}")
	public ResponseEntity<?> delete(@PathVariable("email") String email) {
		if (!usuarioService.existsByEmail(email)) {
			return new ResponseEntity(new Mensaje("El usuario no se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}
		usuarioService.delete(usuarioService.getByEmail(email).get().getId());
		return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
	}

}
