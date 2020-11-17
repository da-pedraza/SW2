package co.edu.unbosque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.entity.Formacion;

@Repository
public interface FormacionRepository extends JpaRepository<Formacion, Integer> {

}
