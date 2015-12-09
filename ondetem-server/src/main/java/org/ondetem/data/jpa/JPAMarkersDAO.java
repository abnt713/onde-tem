package org.ondetem.data.jpa;

import org.ondetem.data.MarkersDAO;
import org.ondetem.entities.Marker;
import org.ondetem.exceptions.MemberNotExistError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JPAMarkersDAO implements MarkersDAO{
	
	@Autowired
	private JPAMarkersRepository repository;
	
	public JPAMarkersRepository getRepository() {
		return repository;
	}
	public void setRepository(JPAMarkersRepository repository) {
		this.repository = repository;
	}

	@Override
	public Marker get(Long markerId) {
		return getRepository().findOne(markerId);
	}

	@Override
	public Iterable<Marker> findAll() {
		return getRepository().findAll();
	}

	@Override
	public Marker create(Marker marker) {
		marker.setId(null);
		return getRepository().save(marker);
	}
	@Override
	@Transactional
	public void update(Marker marker) {
		if(marker.getId() == null || !exists(marker.getId())){
			throw new MemberNotExistError("Marker with id " + marker.getId() + " does not exist.");
		}
		getRepository().save(marker);
	}
	
	@Override
	public boolean exists(Long markerId) {
		return getRepository().exists(markerId);
	}
}
