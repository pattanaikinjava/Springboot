package com.drools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDroolApplication {

	public static void main(String[] args) {
		System.out.println("************ Spring boot application started ************");
		SpringApplication.run(BootDroolApplication.class, args);
		//System.out.println("************ Spring boot application stoped ************");
	}

}
