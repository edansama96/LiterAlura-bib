package com.bibliotec.LiterAlura_bib.literAlura.primal;

import com.bibliotec.LiterAlura_bib.literAlura.model.*;
import com.bibliotec.LiterAlura_bib.literAlura.service.ConsumoApi;
import com.bibliotec.LiterAlura_bib.literAlura.service.ConvierteDatos;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Clase principal que permitira interactuar con l usuario atravez de un menu
 * se configuran los métodos necesarios para la aplicación
 *
 * */
public class Primal {

    //Variable que maneja la información constante de la URI del api
    private final String URL_BASE = "https://gutendex.com/books/";
   //Variable que maneja la instnacia de Scanner para obtener los datos por consola
    private Scanner teclado = new Scanner(System.in);
    //Instnacia de la clase conver datos para convertir los datos
    private final ConvierteDatos conversor = new ConvierteDatos();
    //Instancias para usar la clase que consume el API
    private final ConsumoApi consumoApi = new ConsumoApi();

    //Método utilizado para crear el menu de la aplicación
    // en donde este funcionara por consola
    public void  showTheMenu(){
        System.out.println("Si llega a este punto");
        var opcion = -1;
        while(opcion != 0){
            var menu = """
                1 - Buscar Libro por titulo
                
                0-salir
                """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroPorTitulo();
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }


    }

    private void buscarLibroPorTitulo() {
            Scanner entrada = new Scanner(System.in);

            System.out.print("Ingresa el libro que quieras buscar: ");
            //Variable que guarda la información ingresada por el usuario
            var nombreLibro = entrada.nextLine();
            //variable que se usara para indivar que las palabras seran procesada al usar UTF8 y con esto se asegura
        // que si el usaurio ingresa caracteres espaciales los modifique, además también reemplaza los espacios por +
        // que es otra forma de poder concatenar las palabras aparte del %20 indicada por el usauri
            var nombreLibroCodificado = URLEncoder.encode(nombreLibro, StandardCharsets.UTF_8);
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibroCodificado);
        //System.out.println("Información manejada: " +json);
            if (json == null) {
                System.out.println("No se pudo obtener información del API.");
                return;
            }
            //se guarda la información de resultados en la instnacia
        // de la clase data resultados, además de usar el conversor para indicar que la información json
        // es de tipo dataresultados
            DataResultBooks librosResultado = conversor.obtenerDatos(json, DataResultBooks.class);
            //Se valida que la información guardada en librosResultados no sea null
            if (librosResultado.results() == null || librosResultado.results().isEmpty()) {
                System.out.println("No se encontraron libros con ese nombre.");
                return;
            }
            //Se utilizopara validar la forma en la cual se obtenian el primer dato de la lista resultados del api
//        System.out.println("----------------Hola");
//            //avance en la forma de poder obtener el primer dato de la lista result
//            var prueba =librosResultado.results().get(0);
//        System.out.println("Prueba" + prueba);
//        System.out.println("----------------Hola");
        //Manejo de toda la lista results se procede a mostra la información importante obtenida directamente de la API
//            System.out.println("Libros encontrados:\n");
//            librosResultado.results().forEach(libro -> {
//                System.out.println("----------------------------");
//                System.out.println("Título: " + libro.title());
//                System.out.println("Autores: ");
//                libro.authors().forEach(a -> {
//                    System.out.println("Nombre: " + a.name());
//                    System.out.println("Fecha de nacimiento: " + a.birthYear());
//                    System.out.println("Fecha de Muerte: " + a.deathYear());
//                });
//                System.out.println("Idiomas: " + libro.languages());
//                System.out.println("Descargas: " + libro.downloadCount());
//                System.out.println("----------------------------");
//            });
//        System.out.println("Primera version------- arriba");

        /**
         * Se realizaron conversiones debido a que se tenian una clase Record que contiene results del api manejada
         * dicha api en esa lista results contiene toda la información de libros y autores que se desea utilizar
         * por  eso se uso dicha clase y los parametros de autor y libros para convetirlos en las clases adecuadas de
         * libro y autor
         * */

        List<DataBook> librosConvertidos = librosResultado.results().stream()
                .map(libro -> new DataBook(
                        libro.title(),
                        libro.authors(),
                        libro.languages(),
                        libro.downloadCount()
                ))
                .distinct()
                .collect(Collectors.toList());
//        System.out.println("Lista de libros:------------------------------------");
//        System.out.println("Cambio");
//        librosConvertidos.forEach(libro-> {
//            System.out.println("Título: " + libro.title());
//            System.out.println("Idiomas: " + libro.languages());
//            System.out.println("Autor o Autores: " + libro.authors());
//            System.out.println("Descargas: " + libro.downloadCount());
//            System.out.println("----------------------------\n");
//        });
//        System.out.println("Lista de libros:------------------------------------\n");

        /**
         * Se realiza la conversión de la infroamción o data
         * a objetos de tipo clase Book
         *
         *
         * */
        List<Book> books = librosResultado.results().stream()
                .map(infoBook -> new Book(
                   infoBook.title(),
                   infoBook.authors(),
                   Language.fromString(
                           infoBook.languages().isEmpty() ? null : infoBook.languages().get(0)),
                   infoBook.downloadCount()
                ))
                .distinct()
                .collect(Collectors.toList());

        books.forEach(System.out::println);


        //Se procede realizar una conversión de resultadoDatos a DataAuthor
        //EN este caso siver para la situación en donde solo se mostrara la información al usar el flatmap
        List<DataAuthor> autoresUnicos = librosResultado.results().stream()
                .flatMap(escritor -> escritor.authors().stream())
                .distinct() // evita duplicados si los record tienen equals/hashCode implementado
                .collect(Collectors.toList());

//        System.out.println("Lista de autores-----------------------------");
//        autoresUnicos.forEach(aut -> {
//            System.out.println("Autor: " +aut.name());
//            System.out.println("Fecha de nacimiento: " +aut.birthYear());
//            System.out.println("Fecha de muerte: " + aut.deathYear());
//        });
//        System.out.println("Lista de autores-----------------------------");


       //Se convierte los datos a una lista de Autores
        /**
         * Para poder realizar la conversión necesaria primero
         * se cambie y accede a la información del libro que es el
         * primer espacio de lista para así depsues ingresar al
         * espacio de lista de autor o autores
         * */

        List<Author> autoresInfo = librosResultado.results().stream()
                .flatMap(dataBook -> dataBook.authors().stream())
                .distinct()
                .map(dataAuthor -> new Author(
                        dataAuthor.name(),
                        dataAuthor.birthYear(),
                        dataAuthor.deathYear()

                )).collect(Collectors.toList());
        autoresInfo.forEach(System.out::println);








    }

}
