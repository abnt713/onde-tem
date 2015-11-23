package org.ondetem.data.memory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.ondetem.data.MarkersDAO;
import org.ondetem.entities.Marker;
import org.springframework.stereotype.Service;

@Service
public class MemoryMarkersDAO implements MarkersDAO {
	private final Collection<Marker> markers;
	
	public MemoryMarkersDAO() {
		markers = new ArrayList<>();
		markers.addAll(Arrays.asList(new Marker(0,0,"Center of the world")
				, new Marker(-5.84132, -35.19833, "dimap")
				, new Marker(-5.83219, -35.20531, "IMD")
				, new Marker(-5.83330,-35.20369, "Restaurante Universitário")
				, new Marker(-5.83239,-35.20469, "Residência Universitária")
				));
	}
	
	@Override
	public Collection<Marker> list() {
		return markers;
	}

	@Override
	public Marker create(Marker marker) {
		Marker newMarker = new Marker(marker);
		markers.add(newMarker);
		return newMarker;
	}

}
