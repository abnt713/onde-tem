package org.ondetem.data;

import org.ondetem.entities.Marker;

public interface MarkersDAO {
	public Marker get(Long markerId);
	public Iterable<Marker> findAll();
	public Marker create(Marker marker);
	public void update(Marker marker);
	public boolean exists(Long markerId);
}
