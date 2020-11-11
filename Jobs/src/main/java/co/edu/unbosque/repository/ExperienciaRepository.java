package co.edu.unbosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Experiencia;


@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer> {

}
