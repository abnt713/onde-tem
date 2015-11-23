package org.ondetem;

import org.ondetem.data.DataLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	@Autowired
	DataLayer layer;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Bean
	public CommandLineRunner demo() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println(layer);
			}
		};
    	
    }
}
