package com.bibliotec.LiterAlura_bib.literAlura.model;


import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "books")
public class Book {
    //variable para manejar el id
    // como también la forma que se genera que es automatica y
    // el estilo o manejo que tendra para realizar los id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idb;
    //Anotación para que cada serie sea unica y no se repita
    @Column(unique = true)
    private String title;
    //Se establece la relación de muchos a muchos,  se usa el fetch para que
    // se carge cuando se necesite la información relacionada
    // cascade para representar  que se refleje los cambios que se realicen
    // con el Join Table, se maneja la tabla intermedia entre las
    //tablas book y authors , en donde por medio de su id se puedan identificar
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;
    //Anotación para indicar el uso del enum con el que se establece parametros predefinidos
    @Enumerated(EnumType.STRING)
    private Language languages;
    private Integer downloadCount;
    //JPA exige un constructor predeterminado
    public Book() {

    }

    public Book(String title, List<Author> authors, Language languages, Integer downloadCount) {
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", downloadCount=" + downloadCount;
    }
}
