package com.example.julspringweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// 서버 동작, ComponentScan
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class JulspringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JulspringwebApplication.class, args);
	}

}
