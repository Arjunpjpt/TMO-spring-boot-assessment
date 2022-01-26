package com.galvanize.tmo.paspringstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.galvanize.tmo")
@EntityScan("com.galvanize.tmo")

public class PaSpringStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaSpringStarterApplication.class, args);
	}

}
