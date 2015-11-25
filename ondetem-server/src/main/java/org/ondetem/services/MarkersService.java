package org.ondetem.services;

import org.ondetem.data.DataLayer;
import org.ondetem.entities.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkersService {

	@Autowired
	private DataLayer dataLayer;
	
	public DataLayer getDataLayer() {
		return dataLayer;
	}
	public void setDataLayer(DataLayer dataLayer) {
		this.dataLayer = dataLayer;
	}

	public Iterable<Marker> list(){
		System.out.println("MarkerDAO is: " + dataLayer.getMarkersDAO());
		System.out.println("JPAMarkerDAO is: " + dataLayer.getJpaDAO());
		return dataLayer.getMarkersDAO().findAll();
	}
	public Marker create(Marker marker){
//		return marker;
		return dataLayer.getMarkersDAO().save(marker);
	}
}
