package com.nsanchez1310.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nsanchez1310.cursomc.services.DBService;

@Configuration
//spring.datasource.url=jdbc:mysql://localhost:3306/curso_spring
@Profile("test")

public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instantiateTestDatabase();		
		return true;
		
	}

}