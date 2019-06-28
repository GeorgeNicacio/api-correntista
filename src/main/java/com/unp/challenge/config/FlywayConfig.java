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
		flyway.setBaselineOnMigrate(true);
		flyway.migrate();
	} 
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		// Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:sqlserver://localhost:49172;databaseName=master;integratedSecurity=true;", null, null).load();

        // Start the migration
        //migrate(flyway);
		
		return true;
	}
	
  
    
}