package org.ondetem.config;

final public class ApiRequestMapping {

	public static final String API_V1_PREFIX = "/api/v1"; 

	public static final String MARKERS_ROUTE =  API_V1_PREFIX + "/markers";

	public static final String MARKERS_RATE_ROUTE = MARKERS_ROUTE + "/{id}/rate";
	
}
