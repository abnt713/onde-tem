package org.ondetem.data;

import org.ondetem.data.jpa.JPAMarkersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class DataLayer {
	@Autowired
	@Qualifier("persistent")
	private MarkersDAO markersDAO;

	@Autowired
	private JPAMarkersDAO jpaDAO;
	
	public MarkersDAO getMarkersDAO() {
		return markersDAO;
	}

	public void setMarkersDAO(MarkersDAO markersDAO) {
		this.markersDAO = markersDAO;
	}

	public JPAMarkersDAO getJpaDAO() {
		return jpaDAO;
	}

	public void setJpaDAO(JPAMarkersDAO jpaDAO) {
		this.jpaDAO = jpaDAO;
	}
	
	
}
