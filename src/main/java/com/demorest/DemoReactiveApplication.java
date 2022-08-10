package com.demorest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;



@SpringBootApplication
@EnableReactiveMongoRepositories 
public class DemoReactiveApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoReactiveApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
	}

}
