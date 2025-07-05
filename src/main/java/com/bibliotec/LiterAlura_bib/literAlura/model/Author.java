package com.bibliotec.LiterAlura_bib.literAlura.model;

import jakarta.persistence.*;

import java.util.List;
/**
 * Clase principal de Author se manejan los parametros id, name, birthyear, deathyear
 * y books, así como se usa la anotación para indicar que es una entiendad, como para manejar el nombre de la tabla
 *
 * */
@Entity
@Table(name = "authors")
public class Author {
    /**
     * Se maneja las anotaciones de id, y generar el valor para poder manejar el
     * auto generación del id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;
    /**
     * Se utilizara la anotación ManyTomany y MappeBy para indicar que esta es la tabla dependiente
     * */
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

}
