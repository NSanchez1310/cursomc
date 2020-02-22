package com.nsanchez1310.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nsanchez1310.cursomc.services.DBService;
import com.nsanchez1310.cursomc.services.EmailService;
import com.nsanchez1310.cursomc.services.SmtpEmailService;

@Configuration
//spring.datasource.url=jdbc:mysql://localhost:3306/curso_spring

@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		if (!"create".equals(strategy)) {
			return false;
		} 
		
		dbService.instantiateTestDatabase();		
		return true;
		
	}
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
