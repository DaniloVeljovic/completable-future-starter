package de.dveljovic.completable_future_starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CompletableFutureStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompletableFutureStarterApplication.class, args);
	}

}
