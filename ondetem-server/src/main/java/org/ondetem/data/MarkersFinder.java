package org.ondetem.data;

import java.util.List;

import org.ondetem.entities.Marker;

public interface MarkersFinder {
	public List<Marker> search(String query);
}
