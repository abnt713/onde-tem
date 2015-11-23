package org.ondetem.api;

import org.ondetem.config.ApiRequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiRequestMapping.API_V1_PREFIX)
public class ApiController {

	static final ApiRoutes routes = new ApiRoutes();
	
    @RequestMapping(method=RequestMethod.GET)
    public ApiRoutes greeting() {
    	return routes;
    }
}
