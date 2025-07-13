package com.bibliotec.LiterAlura_bib.literAlura;

import com.bibliotec.LiterAlura_bib.literAlura.primal.Primal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 *Uso de la interfaz commanlinerun
 * */

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	//Método sobre escrito usado desde la clase interfas implementada
	@Override
	public void run(String... args) throws Exception {
		Primal buscador = new Primal();
		buscador.showTheMenu();

	}
}
