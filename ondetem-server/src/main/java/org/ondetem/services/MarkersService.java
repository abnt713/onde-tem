package org.ondetem.services;

import java.util.Collection;

import org.ondetem.data.DataFacade;
import org.ondetem.data.MarkersDAO;
import org.ondetem.entities.Marker;
import org.springframework.stereotype.Service;

@Service
public class MarkersService {

	private MarkersDAO markersDAO;
	
	public MarkersService() {
		markersDAO = DataFacade.dataLayer().getMarkersDAO();
	}

	public Collection<Marker> list(){
		return (Collection<Marker>) markersDAO.findAll();
	}
	public Marker create(Marker marker){
//		return marker;
		return markersDAO.save(marker);
	}
}
