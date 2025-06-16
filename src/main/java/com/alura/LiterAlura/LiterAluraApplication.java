package com.alura.LiterAlura;

import com.alura.LiterAlura.main.Principal;
import com.alura.LiterAlura.repository.AutorRepository;
import com.alura.LiterAlura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autorRepository, livroRepository);
		principal.exibeMenu();
	}
}
