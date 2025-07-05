package com.bibliotec.LiterAlura_bib.literAlura.model;

public enum Language {
    /**
     * Clase enum Lenguaje para manejar unas constantes propias
     * de los lenguajes de los libros que se podran buscar
     *Ahora se definiran las constantes de los lenguajes manejados
     * */
    ENGLISH("en","Inglés" ),
    SPANISH("es", "Español"),
    FRENCH("fr", "Framcés"),
    PORTUGUESE("pt", "Portugues"),
    UNKNOWN("unknow", "Desconocido");

    private String lenguageGutendex;

    private String lenguageGutendexred;

    Language(String lenguageGutendex, String lenguageGutendexred) {
        this.lenguageGutendex = lenguageGutendex;
        this.lenguageGutendexred = lenguageGutendexred;
    }
}
