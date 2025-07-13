package com.bibliotec.LiterAlura_bib.literAlura.service;

import com.bibliotec.LiterAlura_bib.literAlura.model.DataBook;

import java.io.IOException;
import java.util.List;

public interface IConvierteDatos {
    //Se manejara un Datps series para obtener datos de los libros
    //sE USARA UN DATO genereico de java
//     <T> List <T> obtenerDatos(String json, Class<T> clase) throws IOException;
    <T> T obtenerDatos(String json, Class<T> clase) throws IOException;
}
