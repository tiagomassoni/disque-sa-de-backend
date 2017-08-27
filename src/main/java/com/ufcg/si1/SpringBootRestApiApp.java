package com.ufcg.si1;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repositories.AdminstradorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.tools.jar.CommandLine;


@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan combined
public class SpringBootRestApiApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApp.class, args);
	}

	@Bean
    CommandLineRunner init (AdminstradorRepository admRepository){
	    Administrador adm_sudo = new Administrador("Administrador da Prefeitura", "adm@prefeitura.cg","1234567");
        return (evt) -> admRepository.save(adm_sudo);
	}
}
