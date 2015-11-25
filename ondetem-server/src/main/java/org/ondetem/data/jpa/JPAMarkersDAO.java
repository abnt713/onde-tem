package org.ondetem.data.jpa;

import org.ondetem.data.MarkersDAO;
import org.ondetem.entities.Marker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;

@Qualifier("persistent")
public interface JPAMarkersDAO extends CrudRepository<Marker, Long>, MarkersDAO{

}
