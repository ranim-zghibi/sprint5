package com.example.parfums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.parfums.entities.Marque;
import com.example.parfums.entities.Parfum;

@SpringBootApplication
@EnableDiscoveryClient
public class ParfumsApplication implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	

	public static void main(String[] args) {
		SpringApplication.run(ParfumsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Parfum.class, Marque.class);
		
	}

}
