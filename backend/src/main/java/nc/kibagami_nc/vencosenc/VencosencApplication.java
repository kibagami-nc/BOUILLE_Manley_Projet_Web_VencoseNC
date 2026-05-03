package nc.kibagami_nc.vencosenc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VencosencApplication {

	// Point d'entree de l'appli : lance le serveur Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(VencosencApplication.class, args);
	}

}
