package org.ondetem.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLayer {
	@Autowired
	private MarkersDAO markersDAO;

	public MarkersDAO getMarkersDAO() {
		return markersDAO;
	}

	public void setMarkersDAO(MarkersDAO markersDAO) {
		this.markersDAO = markersDAO;
	}
	
}
