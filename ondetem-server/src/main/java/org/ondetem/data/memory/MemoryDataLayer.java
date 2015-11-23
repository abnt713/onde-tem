package org.ondetem.data.memory;

import org.ondetem.data.DataLayer;
import org.ondetem.data.MarkersDAO;

public class MemoryDataLayer implements DataLayer{
	MemoryMarkersDAO markersDAO;
	
	public MemoryDataLayer() {
		markersDAO = new MemoryMarkersDAO();
	}
	
	public MarkersDAO getMarkersDAO(){
		return markersDAO;
	}
}
