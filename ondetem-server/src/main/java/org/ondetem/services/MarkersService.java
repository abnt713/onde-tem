package org.ondetem.services;

import org.ondetem.data.DataLayer;
import org.ondetem.data.MarkersDAO;
import org.ondetem.data.MarkersFinder;
import org.ondetem.entities.Marker;
import org.ondetem.entities.RateValue;
import org.ondetem.services.exceptions.InvalidRateScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return getDAO().findAll();
	}
	public Marker create(Marker marker){
		return getDAO().create(marker);
	}
	public Iterable<Marker> search(String query) {
		return markersFinder.search(query);
	}
	
	@Transactional
	public Marker rate(Long markerId, RateValue rateValue) {
		if(rateValue.getScore() != 1 && rateValue.getScore() != -1 ){
			throw new InvalidRateScore("Rate score " + rateValue.getScore() + " is invalid");
		}
		
		Marker marker = getMarker(markerId);
		marker.setRating(marker.getRating() + rateValue.getScore());

		getDAO().update(marker);
		
		return getMarker(markerId);
	}
	private Marker getMarker(Long markerId) {
		return getDAO().get(markerId);
	}

	private MarkersDAO getDAO() {
		return dataLayer.getMarkersDAO();
	}
}
