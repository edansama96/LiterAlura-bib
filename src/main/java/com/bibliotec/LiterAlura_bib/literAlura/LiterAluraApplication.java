package com.bibliotec.LiterAlura_bib.literAlura;

import com.bibliotec.LiterAlura_bib.literAlura.primal.Primal;
import com.bibliotec.LiterAlura_bib.literAlura.repository.AuthorRepository;
import com.bibliotec.LiterAlura_bib.literAlura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 *Uso de la interfaz commanlinerun
 * */

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
	//Como esta clase si la maneja JPA al se creada por defecto
	// se utiliza el Autowired para que se realice una inyección por dependencia
	@Autowired
	//Se indica el atributo que se le inyectara la dependencia para Book
	private BookRepository repositoryB;
	@Autowired
	//Se indica el atributo que se le inyectara la dependencia para AUHTOR
	private AuthorRepository repositoryA;

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	//Método sobre escrito usado desde la clase interfas implementada
	@Override
	public void run(String... args) throws Exception {
		Primal buscador = new Primal( repositoryA,repositoryB);
		buscador.showTheMenu();

	}
}
