package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.repository.CiudadRepository;


@Service
@Transactional
public class CiudadService {

	@Autowired
	CiudadRepository ciudadRepository;
	
	public List<Ciudad> list(){
		return ciudadRepository.findAll();
	}
	
	public Optional<Ciudad> getOne(int id){
		return ciudadRepository.findById(id);
	}
	

	public void save(Ciudad ciudad) {
		ciudadRepository.save(ciudad);
	}
	
	public void delete(int id) {
		ciudadRepository.deleteById(id);
	}
	
}
