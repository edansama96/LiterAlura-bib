package com.bibliotec.LiterAlura_bib.literAlura.model;

import java.util.List;

public enum Language {
    /**
     * Clase enum utilizada para establecer una cantidad
     * definida de categorias con el cual la aplicación
     * funcionara e interactuara con los idiomas obtenidos
     * del api que seran o no reconocidos dependiendo
     * de las constantes que se definan en la presnete clase
     *
     * */
    EN("en","Inglés" ),
    ES("es", "Español"),
    DE("de", "Aelmán"),
    FR("fr", "Francés"),
    IT("it", "Italiano"),
    PT("pt", "Portugués");

    /**
     * Se manejan variables
     * para manejar el idio del api Gutendex y
     * las constantes establecidas
     * */
    private String lenguageGuntendex;
    private String nombreEspanol;

    /**
     * Constructor que indicara la forma en la cuar se
     * inicializaran dichas constantes
     * */
    Language(String lenguageGuntendex, String nombreEspanol) {
        this.lenguageGuntendex = lenguageGuntendex;
        this.nombreEspanol = nombreEspanol;
    }

    /*
    * Método utilizado la conversión de
    *    los datos de Guntendex a las contantes
    * establecidas en la aplicación
    * */

    public static  Language fromString(String text){
        for(Language language : Language.values()){
            if(language.lenguageGuntendex.equalsIgnoreCase(text)){
                return language;
            }
        }
        throw new IllegalArgumentException("Lenguaje no encontrado: " + text);
    }


}
