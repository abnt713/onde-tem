package org.ondetem.api;

import org.ondetem.config.ApiRequestMapping;
import org.ondetem.entities.Marker;
import org.ondetem.services.MarkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
}
