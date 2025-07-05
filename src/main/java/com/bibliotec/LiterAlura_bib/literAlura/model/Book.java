package com.bibliotec.LiterAlura_bib.literAlura.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Clase principal de Book se establecen los parametros de entrada observador en el api
 * Para el presente ejercicio se utiliza el api de Gutendex para validar más info:  https://gutendex.com/
 * para el presente caso los parametros usados son
 * Id, titulo, resumen, lenguaje, cuenta de descargar y autor
 * */
/**
 * Se usara las notación Entinty y Table, el entity para indicar a jpa que es una entidad
 * y table para indicar el nombre de la tabla
 * */
@Entity
@Table(name = " books")
public class Book {
    /**
     * Se procede a indicar el uso del id y de como este se
     * ira autogenerando usando identity
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String title;
    private String summaries;
    /**
     * Anotación para indicar que se creara una clase Enum, para
     * personalizar los lenguajes que seran utilizados en la presente aplicación
     * */
    @Enumerated(EnumType.STRING)
    private String lenguages;
    private String dowloaf_count;
    //Conexión con la tabla seria de muchos a muchos
    /**
     * La conexión con la entre las entidades de la base de datos es de muchos a muchos
     * debido a que  1 autor puede tener muchos libros y 1 libro puede tener muchos autores
     * ademas también de le indica en esta clase la tabla intermedia que se manejara entre la talba
     * books y authors
     * */
    @ManyToMany
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Author> authors;
}
