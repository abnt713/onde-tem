package org.ondetem.data;

import org.ondetem.config.DataConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class DataFacade {
	private static DataLayer data;
	
	public static DataLayer dataLayer(){
		if(data == null){
			try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DataConfiguration.class)){
				data = ctx.getBean(DataLayer.class);
			}
		}
		return data;
	}
}
