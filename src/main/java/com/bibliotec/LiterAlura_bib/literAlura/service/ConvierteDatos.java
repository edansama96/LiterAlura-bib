package com.bibliotec.LiterAlura_bib.literAlura.service;

import com.bibliotec.LiterAlura_bib.literAlura.model.DataAuthor;
import com.bibliotec.LiterAlura_bib.literAlura.model.DataBook;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

//Se implemetara la clase Interfaz Covierte datos
public class ConvierteDatos implements IConvierteDatos {
    //Instancia de un objtecMapper, para leer o maper la inforamción de la API
    private ObjectMapper objectMapper = new ObjectMapper();

    //Implementación de uno de los metodo de la interfaz
    //@Override
    // Método genérico que transforma un JSON en un objeto Java de cualquier tipo (T)
//    public <T> List<T> obtenerDatos(String json, Class<T> clase) {
//        try {
//            // Paso 1: Convertir el JSON en un árbol de nodos
//            JsonNode root = objectMapper.readTree(json);
//
//            // Paso 2: Extraer el nodo 'results'
//            JsonNode resultados = root.get("results");
//
//            // Paso 3: Deserializar 'results' en una lista del tipo indicado
//            List<T> datos = objectMapper.readerForListOf(clase).readValue(resultados);
//
//            // Paso 4: Mostrar la información por consola (solo si T es DataBook)
//            if (clase.equals(DataBook.class)) {
//                for (T item : datos) {
//                    DataBook libro = (DataBook) item;
//                    System.out.println("-----------");
//                    System.out.println("Título: " + libro.title());
//                    //System.out.println("Resumen: " + libro.summaries());
//                    System.out.println("Idioma(s): " + libro.languages());
//                    System.out.println("Descargas: " + libro.downloadCount());
//                    System.out.println("-----------\n");
//                }
//            } else if (clase.equals(DataAuthor.class)) {
//                for (T item : datos){
//                    DataAuthor author = (DataAuthor) item;
//                    System.out.println("Nombre: " + author.name());
//                    System.out.println("Fecha de nacimiento: " + author.birthYear());
//                    System.out.println("Fecha de muerte: " +author.deathYear());
//
//                }
//            }
//
//            // Paso 5: Devolver la lista
//            return datos;
//
//        } catch (JsonProcessingException e) {
//            System.out.println("Error al procesar el JSON: " + e.getMessage());
//            e.printStackTrace();
//            return List.of(); // Retorna lista vacía en caso de error
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @Override
    public <T> T  obtenerDatos(String json, Class<T> clase) {
        //vamos a retornar un readValue(String, Clase) que convierte
        //el JSON a Objeto Java, en este caso json = json, y
        //Clase = clase -> que es lo que se está recibiendo
        try {
////                var validar =objectMapper.readValue(json, clase);
////                if(validar.n){
////
////                }else{
//
//                }

            return  objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
