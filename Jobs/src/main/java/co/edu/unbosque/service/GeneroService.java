package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.Genero;
import co.edu.unbosque.repository.GeneroRepository;

@Service
@Transactional
public class GeneroService {
	
	@Autowired
	GeneroRepository generoRepository;
	
	public List<Genero> list(){
		return generoRepository.findAll();
	}
	
	public Optional<Genero> getOne(int id){
		return generoRepository.findById(id);
	}
	

	public void save(Genero genero) {
		generoRepository.save(genero);
	}
	
	public void delete(int id) {
		generoRepository.deleteById(id);
	}

}
