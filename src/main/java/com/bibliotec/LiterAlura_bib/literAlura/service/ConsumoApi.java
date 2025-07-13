package com.bibliotec.LiterAlura_bib.literAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    // Método que realiza una solicitud HTTP GET a la URL indicada y devuelve la respuesta como texto (JSON, por ejemplo)
    public String obtenerDatos(String url) {

        // Se crea un cliente HTTP con configuración por defecto (Java 11+)
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        // Se construye una solicitud HTTP tipo GET a partir de la URL dada
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // Convierte el String 'url' en un objeto URI
                //.header("User-Agent", "Mozilla/5.0")
                //.GET()
                .build(); // Finaliza la construcción de la solicitud

        // Se declara la variable que almacenará   la respuesta del servidor
        HttpResponse<String> response ;

        // Bloque try-catch para manejar posibles errores al enviar la solicitud
        try {
            // Se envía la solicitud y se espera la respuesta de forma sincrónica
            // La respuesta se interpretará como texto plano (String)
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Se valida la comunicaicón con ser servidor mostrando el estado de la conexión
            System.out.println("Código de estado HTTP: " + response.statusCode());



        } catch (IOException e) {
            // Si ocurre un error de entrada/salida (por ejemplo, problema de red), se lanza una excepción no verificada
            throw new RuntimeException(e);

        } catch (InterruptedException e) {
            // Si el hilo es interrumpido mientras espera la respuesta, también se lanza como RuntimeException
            throw new RuntimeException(e);
        }

        // Se extrae el cuerpo (body) de la respuesta HTTP, usualmente un JSON
        String json ;
        //Si el estatus de la conexión es 200 se muestra la información
        // si no se muestra que pasa un error y el status que esta pasando
        if (response.statusCode() == 200) {
            json =  response.body();
        } else {
            System.out.println("Error al hacer la solicitud. Código: " + response.statusCode());
            return null;
        }



        // Se devuelve el cuerpo de la respuesta como String
        return json;
    }


}
