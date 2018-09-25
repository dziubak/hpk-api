package com.hpk.api.standalone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hpk.api")
public class HpkApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(HpkApiApplication.class, args);
	}
}
