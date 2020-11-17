package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.entity.TipoDocumento;
import co.edu.unbosque.repository.TipoDocumentoRepository;

@Service
@Transactional
public class TipoDocumentoService {
	
	@Autowired
	TipoDocumentoRepository tipoDocumentoRepository;
	
	public List<TipoDocumento> list(){
		return tipoDocumentoRepository.findAll();
	}
	
	public Optional<TipoDocumento> getOne(int id){
		return tipoDocumentoRepository.findById(id);
	}
	
	public void save(TipoDocumento tipoDocumento) {
		tipoDocumentoRepository.save(tipoDocumento);
	}
	
	public void delete(int id) {
		tipoDocumentoRepository.deleteById(id);
	}
	

}
