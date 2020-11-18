package co.edu.unbosque.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.enums.RolNombre;
import co.edu.unbosque.repository.RolRepository;

@Service
@Transactional
public class RolService {

	@Autowired
	RolRepository rolRepository;

	public void save(Rol rol) {
		rolRepository.save(rol);
	}

	public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
		return rolRepository.findByRolNombre(rolNombre);
	}

	public boolean existsByRolNombre(RolNombre rolNombre) {
		return rolRepository.existsByRolNombre(rolNombre);
	}

}
