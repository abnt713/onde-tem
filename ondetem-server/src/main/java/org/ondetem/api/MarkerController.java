package org.ondetem.api;

import java.util.Collection;

import org.ondetem.config.ApiRequestMapping;
import org.ondetem.entities.Marker;
import org.ondetem.services.MarkersService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerController {
	private MarkersService markersService;
	
	public MarkerController() {
		markersService = new MarkersService();
	}
	
	@RequestMapping(value=ApiRequestMapping.MARKERS_ROUTE, method=RequestMethod.GET)
    public Collection<Marker> listMarkers() {
        return markersService.list();
    }
	

	@RequestMapping(value=ApiRequestMapping.MARKERS_ROUTE, method=RequestMethod.POST)
	public Marker createMarker(@RequestBody Marker marker){
		return markersService.create(marker);
	}
	
}
