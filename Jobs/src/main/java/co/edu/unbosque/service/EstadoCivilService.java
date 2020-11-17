package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.EstadoCivil;
import co.edu.unbosque.repository.EstadoCivilRepository;

@Service
@Transactional
public class EstadoCivilService {

	@Autowired
	EstadoCivilRepository estadoCivilRepository;

	public List<EstadoCivil> list() {
		return estadoCivilRepository.findAll();
	}

	public Optional<EstadoCivil> getOne(int id) {
		return estadoCivilRepository.findById(id);
	}

	public void save(EstadoCivil estadoCivil) {
		estadoCivilRepository.save(estadoCivil);
	}

	public void delete(int id) {
		estadoCivilRepository.deleteById(id);
	}

}
