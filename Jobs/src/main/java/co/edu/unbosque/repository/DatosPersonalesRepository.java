package co.edu.unbosque.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.DatosPersonales;
import co.edu.unbosque.entity.Usuario;

@Repository
public interface DatosPersonalesRepository extends JpaRepository<DatosPersonales, Integer> {
	Optional<DatosPersonales> findByNumDocumento(int num);
	boolean existsByNumDocumento(int num);
	
}
