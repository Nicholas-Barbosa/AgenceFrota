package com.agence.frota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.agence.frota.sfbean")
public class ProjetoFrotaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFrotaApplication.class, args);
	}

}
