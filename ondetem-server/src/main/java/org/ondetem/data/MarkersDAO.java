package org.ondetem.data;

import org.ondetem.entities.Marker;

public interface MarkersDAO {
	public Iterable<Marker> findAll();
	public Marker save(Marker marker);
}
