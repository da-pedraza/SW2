package co.edu.unbosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
