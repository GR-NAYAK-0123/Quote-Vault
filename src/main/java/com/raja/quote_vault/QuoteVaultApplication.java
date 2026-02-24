package com.raja.quote_vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
public class QuoteVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoteVaultApplication.class, args);
	}

}
