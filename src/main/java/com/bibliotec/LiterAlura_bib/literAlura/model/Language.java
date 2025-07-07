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

    private final String lenguageGutendex;

    private final String lenguageGutendexred;

    Language(String lenguageGutendex, String lenguageGutendexred) {
        this.lenguageGutendex = lenguageGutendex;
        this.lenguageGutendexred = lenguageGutendexred;
    }

    /**
     * Método para realizar las comparaciones entre los lenguajes manejados por
     * el api gutendex con los lengujes establecidos como constantes aquí
     * */
    public static Language fromConverString(String text){

        for(Language language : Language.values()){
            if(language.lenguageGutendex.equalsIgnoreCase(text)){
                return language;
            }

        }
        throw new IllegalArgumentException("Lenguaje no encontrado. " + text);

    }
}
