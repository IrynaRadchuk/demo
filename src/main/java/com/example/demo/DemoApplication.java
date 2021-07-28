package com.example.demo;

import com.example.demo.repository.ActivityRepository;
import com.example.demo.service.MainService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(ActivityRepository activityRepository) {
		return (args) -> {
			System.out.println(activityRepository.findAll());
		};
	}
}
