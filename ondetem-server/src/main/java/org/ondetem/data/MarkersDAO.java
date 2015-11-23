package org.ondetem.data;

import java.util.Collection;

import org.ondetem.entities.Marker;

public interface MarkersDAO {
	public Collection<Marker> list();
	public Marker create(Marker marker);
}
