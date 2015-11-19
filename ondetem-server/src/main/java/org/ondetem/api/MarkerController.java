package org.ondetem.api;

import java.util.Arrays;
import java.util.Collection;

import org.ondetem.config.ApiRequestMapping;
import org.ondetem.entities.Marker;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarkerController {
	
	@RequestMapping(value=ApiRequestMapping.MARKERS_ROUTE, method=RequestMethod.GET)
    public Collection<Marker> listMarkers() {
        return Arrays.asList(new Marker(0,0,"Center of the world")
				, new Marker(-5.84132, -35.19833, "dimap")
				, new Marker(-5.83219, -35.20531, "IMD")
				, new Marker(-5.83330,-35.20369, "Restaurante Universitário")
				, new Marker(-5.83239,-35.20469, "Residência Universitária")
				);
    }
	

	@RequestMapping(value=ApiRequestMapping.MARKERS_ROUTE, method=RequestMethod.POST)
	public Marker createMarker(@RequestBody Marker marker){
		return marker;
	}
	
}
