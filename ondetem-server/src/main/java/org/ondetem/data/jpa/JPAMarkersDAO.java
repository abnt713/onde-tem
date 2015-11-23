package org.ondetem.data.jpa;

import org.ondetem.data.MarkersDAO;
import org.ondetem.entities.Marker;
import org.springframework.stereotype.Component;

@Component
public class JPAMarkersDAO implements MarkersDAO {
	private JPAMarkersRepository repository;
	
	public JPAMarkersDAO() {
	}
	
	public JPAMarkersDAO(JPAMarkersRepository repository2) {
		this.repository = repository2;
	}

	public void setMarkersRepository(JPAMarkersRepository repository){
		this.repository = repository;
	}
	
	@Override
	public Iterable<Marker> findAll() {
		return repository.findAll();
	}

	@Override
	public Marker save(Marker marker) {
		return repository.save(marker);
	}

}
