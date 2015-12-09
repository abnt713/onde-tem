package org.ondetem.services;

import org.ondetem.data.DataLayer;
import org.ondetem.data.MarkersDAO;
import org.ondetem.data.MarkersFinder;
import org.ondetem.entities.Marker;
import org.ondetem.entities.RateValue;
import org.ondetem.exceptions.DatabaseError;
import org.ondetem.exceptions.MemberNotExistError;
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
		try{
			return getDAO().findAll();
		}
		catch(Throwable ex){ throw new DatabaseError(ex);}
			
	}
	public Marker create(Marker marker){
		try{
			return getDAO().create(marker);
		}
		catch(Throwable ex){ throw new DatabaseError(ex);}
	}
	public Iterable<Marker> search(String query) {
		return markersFinder.search(query);
	}
	
	@Transactional
	public Marker rate(Long markerId, RateValue rateValue) {
		verifyRateScore(rateValue);
		verifyMarkerExistence(markerId);
		
		try{
			Marker marker = getMarker(markerId);
			marker.rate(rateValue.getScore());
	
			getDAO().update(marker);
			
			return getMarker(markerId);
		}
		catch(Throwable ex){ throw new DatabaseError(ex);}
	}
	
	private Marker getMarker(Long markerId) {
		return getDAO().get(markerId);
	}

	private MarkersDAO getDAO() {
		return dataLayer.getMarkersDAO();
	}

	private void verifyRateScore(RateValue rateValue) {
		if(rateValue.getScore() != 1 && rateValue.getScore() != -1 ){
			throw new InvalidRateScore("Rate score " + rateValue.getScore() + " is invalid");
		}
	}
	private void verifyMarkerExistence(Long markerId) {
		if(!getDAO().exists(markerId)){
			throw new MemberNotExistError("Marker with id " + markerId + " does not exist");
		}
	}
}
