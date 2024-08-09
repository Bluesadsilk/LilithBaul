package com.nomudev.LilithBaul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.nomudev.models")
@EnableJpaRepositories(basePackages = "com.nomudev.repositories")
public class LilithBaulApplication {

	public static void main(String[] args) {
		SpringApplication.run(LilithBaulApplication.class, args);
	}

}
