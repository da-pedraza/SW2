package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.DatosPersonales;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.DatosPersonalesRepository;

@Service
@Transactional
public class DatosPersonalesService {

	@Autowired
	DatosPersonalesRepository datosPersonalesRepository;

	public List<DatosPersonales> list() {
		return datosPersonalesRepository.findAll();
	}

	public Optional<DatosPersonales> getOne(int id) {
		return datosPersonalesRepository.findById(id);
	}

	public void save(DatosPersonales dp) {
		datosPersonalesRepository.save(dp);
	}

	public void delete(int id) {
		datosPersonalesRepository.deleteById(id);
	}
	
	public Optional<DatosPersonales> getByNumDocumento(int num){
		return datosPersonalesRepository.findByNumDocumento(num);
	}

	public boolean existsById(int id) {
		return datosPersonalesRepository.existsById(id);
	}
	
	public boolean existsByNumDocumento(int id) {
		return datosPersonalesRepository.existsByNumDocumento(id);
	}

}
