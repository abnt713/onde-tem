package org.ondetem.config;

import org.ondetem.data.DataLayer;
import org.ondetem.data.MarkersDAO;
import org.ondetem.data.jpa.JPADataLayer;
import org.ondetem.data.jpa.JPAMarkersDAO;
import org.ondetem.data.jpa.JPAMarkersRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("org.ondetem.data, org.ondetem")
public class DataConfiguration {
	
//	@Bean
//	public DataLayer getDataLayer(){
//		return new JPADataLayer();
//	}
//	
//	@Bean
//	public MarkersDAO makeJPAMarkerDAO(JPAMarkersRepository markersRepository){
//		return new JPAMarkersDAO(markersRepository);
//	}
}
