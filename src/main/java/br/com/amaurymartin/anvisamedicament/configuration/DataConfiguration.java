package br.com.amaurymartin.anvisamedicament.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DriverManagerDataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/anvisa");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");
		
		return dataSource;
	}
	
}
