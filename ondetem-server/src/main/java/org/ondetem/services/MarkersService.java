package org.ondetem.services;

import java.util.Collection;

import org.ondetem.data.DataFactory;
import org.ondetem.data.MarkersDAO;
import org.ondetem.entities.Marker;
import org.springframework.stereotype.Service;

@Service
public class MarkersService {

	private MarkersDAO markersDAO;
	
	public MarkersService() {
		markersDAO = DataFactory.instance().markersDAO();
	}

	public Collection<Marker> list(){
		return markersDAO.list();
	}
	public Marker create(Marker marker){
//		return marker;
		return markersDAO.create(marker);
	}
}
