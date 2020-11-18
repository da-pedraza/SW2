package co.edu.unbosque.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	Optional<Rol> findByRolNombre(RolNombre rolNombre);

	boolean existsByRolNombre(RolNombre rolNombre);

}
