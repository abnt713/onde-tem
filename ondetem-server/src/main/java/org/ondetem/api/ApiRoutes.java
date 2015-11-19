package org.ondetem.api;

import org.ondetem.config.ApiRequestMapping;

public class ApiRoutes {
	public static class Route{
		public final String route;
		public Route(String route){
			this.route = route;
		}
	}
	public static class Routes{
		public final Route markers = new Route(ApiRequestMapping.MARKERS_ROUTE);
	}
	
	public final Routes routes = new Routes();
}
