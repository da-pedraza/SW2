package co.edu.unbosque.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.Experiencia;
import co.edu.unbosque.repository.ExperienciaRepository;

@Service
@Transactional
public class ExperienciaService {

	@Autowired
	ExperienciaRepository experienciaRepository;
	
	public List<Experiencia> list(){
		return experienciaRepository.findAll();
	}
	
	public void save(Experiencia exp) {
		experienciaRepository.save(exp);
	}
	
	public void delete(int id) {
		experienciaRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return experienciaRepository.existsById(id);
	}
	
}
