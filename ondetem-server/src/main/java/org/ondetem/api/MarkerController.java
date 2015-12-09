package org.ondetem.api;

import org.ondetem.config.ApiRequestMapping;
import org.ondetem.entities.Marker;
import org.ondetem.entities.RateValue;
import org.ondetem.exceptions.ClientError;
import org.ondetem.exceptions.ErrorMessage;
import org.ondetem.services.MarkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerController {
	@Autowired
	private MarkersService markersService;
	
	public MarkerController() {
		markersService = new MarkersService();
	}
	
	public MarkersService getMarkersService() {
		return markersService;
	}
	public void setMarkersService(MarkersService markersService) {
		this.markersService = markersService;
	}

	@RequestMapping(value=ApiRequestMapping.MARKERS_ROUTE, method=RequestMethod.GET)
    public Iterable<Marker> listMarkers(@RequestParam(value="q", required=false) String query) {
		if(query != null){
			return markersService.search(query);
		}
        return markersService.list();
    }

	@RequestMapping(value=ApiRequestMapping.MARKERS_ROUTE, method=RequestMethod.POST)
	public Marker createMarker(@RequestBody Marker marker){
		return markersService.create(marker);
	}

	@RequestMapping(value=ApiRequestMapping.MARKERS_RATE_ROUTE, method=RequestMethod.POST)
	public Marker rateMarker(@PathVariable("id") Long markerId, @RequestBody RateValue rateValue){
		return markersService.rate(markerId, rateValue);
	}
	
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ClientError.class)
	public ErrorMessage onBadRequestError(ClientError err){
		return new ErrorMessage(err);
	}

	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public ErrorMessage onServerError(Throwable err){
		return new ErrorMessage(err);
	}
}
