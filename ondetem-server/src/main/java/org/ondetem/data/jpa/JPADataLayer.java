package org.ondetem.data.jpa;

import org.ondetem.data.DataLayer;
import org.ondetem.data.MarkersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class JPADataLayer implements DataLayer{
	
	@Autowired
	@Qualifier("JPAMarkersDAO")
	MarkersDAO markersDAO;

	@Override
	public MarkersDAO getMarkersDAO() {
		return markersDAO;
	}
}
