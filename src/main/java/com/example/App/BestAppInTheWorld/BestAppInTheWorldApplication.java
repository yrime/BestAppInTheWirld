package com.example.App.BestAppInTheWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BestAppInTheWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestAppInTheWorldApplication.class, args);
		ApplicationContext context = new AnnotationConfigApplicationContext(ExampleClass.class);
		ExampleClass exp = context.getBean(ExampleClass.class);
		exp.run();
	}
}
