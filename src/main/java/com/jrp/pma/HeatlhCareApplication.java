package com.jrp.pma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jrp.pma.dao.LocationRepository;

@SpringBootApplication
public class HeatlhCareApplication {
	
	@Autowired
	LocationRepository locRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HeatlhCareApplication.class, args);
	}

}
