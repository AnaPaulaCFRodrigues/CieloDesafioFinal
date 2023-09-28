package com.desafioFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.desafioFinal.controller")
public class DesafioFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFinalApplication.class, args);
	}

}

