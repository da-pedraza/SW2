package co.edu.unbosque.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.entity.Formacion;
import co.edu.unbosque.repository.FormacionRepository;

@Service
@Transactional
public class FormacionService {
	
	@Autowired
	FormacionRepository formacionRepository;
	
	public List<Formacion> list(){
		return formacionRepository.findAll();
	}
	
	public void save(Formacion exp) {
		formacionRepository.save(exp);
	}
	
	public void delete(int id) {
		formacionRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return formacionRepository.existsById(id);
	}

}
