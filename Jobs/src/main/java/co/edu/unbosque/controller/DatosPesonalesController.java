package co.edu.unbosque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.dao.DatosPersonalesDTO;
import co.edu.unbosque.dao.Mensaje;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.DatosPersonales;
import co.edu.unbosque.entity.EstadoCivil;
import co.edu.unbosque.entity.Genero;
import co.edu.unbosque.entity.TipoDocumento;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.DatosPersonalesService;
import co.edu.unbosque.service.UsuarioService;

@RestController
@RequestMapping("/dp")
@CrossOrigin(origins = "*")
public class DatosPesonalesController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	DatosPersonalesService datosPersonalesService;
	
	@PutMapping("/updatedp/{email}")
	public ResponseEntity<?> update(@PathVariable("email") String email, @RequestBody DatosPersonalesDTO datosPersonalesDTO) {
	
		if (!usuarioService.existsByEmail(email) ) {
			return new ResponseEntity(new Mensaje("El email no se encuentra registrado"), HttpStatus.BAD_REQUEST);
		}
	
		if(datosPersonalesService.existsByNumDocumento(datosPersonalesDTO.getNum_Documento()) && datosPersonalesService.getByNumDocumento(datosPersonalesDTO.getNum_Documento()).get().getUsuario().getEmail().equals(email) == false){
			return new ResponseEntity(new Mensaje("El numero de documento ya existe"), HttpStatus.BAD_REQUEST);
		}
		
		Usuario usuario = usuarioService.getByEmail(email).get();
		DatosPersonales dp = usuario.getDatos_personales();
		Ciudad ciudad = dp.getCiudadResidencia();
		TipoDocumento td = dp.getTipoDocumento();
		EstadoCivil ec = dp.getEstadoCivil();
		Genero g = dp.getGenero();
		dp.setP_Nombre(datosPersonalesDTO.getP_Apellido());
		dp.setS_Nombre(datosPersonalesDTO.getS_Nombre());
		dp.setP_Apellido(datosPersonalesDTO.getP_Nombre());
		dp.setS_Apellido(datosPersonalesDTO.getS_Apellido());
		td.setId(datosPersonalesDTO.getT_Documento());
		dp.setTipoDocumento(td);
		dp.setNumDocumento(datosPersonalesDTO.getNum_Documento());
		dp.setTelefono(datosPersonalesDTO.getTelefono());
		ec.setId(datosPersonalesDTO.getEstadoCivil());
		dp.setEstadoCivil(ec);
		//dp.setEstadoCivil(datosPersonalesDTO.getEstadoCivil());
		dp.setF_Nacimiento(datosPersonalesDTO.getF_Nacimiento());
		g.setId(datosPersonalesDTO.getGenero());
		dp.setGenero(g);
		ciudad.setId(datosPersonalesDTO.getCiudadResidencia());
		dp.setCiudadResidencia(ciudad);
		dp.setUsuario(usuario);
		datosPersonalesService.save(dp);
		return new ResponseEntity(new Mensaje("Usuario actualizado exitosamente"), HttpStatus.OK);
	}
	
	

}
