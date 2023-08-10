package org.asdauroravanchiglia.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class AuroraVanchigliaWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuroraVanchigliaWebsiteApplication.class, args);
	}

}
