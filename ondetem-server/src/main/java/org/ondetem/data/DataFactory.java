package org.ondetem.data;

import org.ondetem.data.memory.MemoryMarkersDAO;

public class DataFactory {
	private static DataFactory factory;
	
	public static DataFactory instance(){
		if(factory == null){
			factory = new DataFactory();
		}
		return factory;
	}
	
	public MarkersDAO markersDAO(){
		return new MemoryMarkersDAO();
	}
}
