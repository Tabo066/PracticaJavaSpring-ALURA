package com.aluracursos.musica;
import com.aluracursos.musica.principal.Principal;
import com.aluracursos.musica.repository.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicaApplication implements CommandLineRunner {

	@Autowired
	private CancionRepository cancionRepo;
	public static void main(String[] args) {
		SpringApplication.run(MusicaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(cancionRepo);
		principal.muestraElMenu();

	}
}