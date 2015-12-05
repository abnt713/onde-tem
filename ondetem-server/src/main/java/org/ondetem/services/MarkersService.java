package org.ondetem.services;

import org.ondetem.data.DataLayer;
import org.ondetem.data.MarkersFinder;
import org.ondetem.entities.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkersService {

	@Autowired
	private DataLayer dataLayer;
	
	@Autowired
	private MarkersFinder markersFinder;
	
	public DataLayer getDataLayer() {
		return dataLayer;
	}
	public void setDataLayer(DataLayer dataLayer) {
		this.dataLayer = dataLayer;
	}

	public MarkersFinder getMarkersFinder() {
		return markersFinder;
	}
	public void setMarkersFinder(MarkersFinder markersFinder) {
		this.markersFinder = markersFinder;
	}
	
	public Iterable<Marker> list(){
		return dataLayer.getMarkersDAO().findAll();
	}
	public Marker create(Marker marker){
		return dataLayer.getMarkersDAO().save(marker);
	}
	public Iterable<Marker> search(String query) {
		return markersFinder.search(query);
	}
}
