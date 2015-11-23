package org.ondetem.data.jpa;

import org.ondetem.entities.Marker;
import org.springframework.data.repository.CrudRepository;

public interface JPAMarkersRepository extends CrudRepository<Marker, Long>{

}
