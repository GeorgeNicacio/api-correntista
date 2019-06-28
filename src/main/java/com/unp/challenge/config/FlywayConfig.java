package com.unp.challenge.config;

import java.text.ParseException;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayConfig implements FlywayMigrationStrategy {

	@Override
	public void migrate(Flyway flyway) {
		
	} 
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		// Create the Flyway instance and point it to the database
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:sqlserver://localhost:49172;databaseName=master;integratedSecurity=true;", null, null, null);
        flyway.setBaselineOnMigrate(true);
        //flyway.migrate();

		return true;
	}
	
  
    
}