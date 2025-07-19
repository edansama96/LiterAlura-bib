package com.bibliotec.LiterAlura_bib.literAlura.primal;

import com.bibliotec.LiterAlura_bib.literAlura.model.*;
import com.bibliotec.LiterAlura_bib.literAlura.repository.AuthorRepository;
import com.bibliotec.LiterAlura_bib.literAlura.repository.BookRepository;
import com.bibliotec.LiterAlura_bib.literAlura.service.ConsumoApi;
import com.bibliotec.LiterAlura_bib.literAlura.service.ConvierteDatos;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
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
    //Variable para guardar la lista de los libros buscados por el autor
    private List <Book> datosBooks = new ArrayList<>();
    //Variable de tipo lista para guardar a los autores registrados
    private List <Author> authorsRegistry = new ArrayList<>();
    //Guardar la información solicitada por el usuario
    private DataResultBooks infoBook;
    //Variable para manejar la información de los procesos de inyección
    private BookRepository repositorioB;
    private AuthorRepository repositorioA;

//Constructor para indicar como se inicializaran las variables para el
    // proceso de inyección de dependencias
    public Primal(AuthorRepository repositoryA, BookRepository repositoryB) {
        this.repositorioB = repositoryB;
        this.repositorioA = repositoryA;
    }

    //Método utilizado para crear el menu de la aplicación
    // en donde este funcionara por consola
    public void  showTheMenu(){
        System.out.println("Si llega a este punto");
        var opcion = -1;
        while(opcion != 0){
            var menu = """
                1 - Buscar Libro por titulo
                2 - Listar libros registrados
                3 - Listar autores registrados
                
                0-salir
                """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }


    }



    private DataResultBooks getDatosBook(String nombreLibro) {

            //variable que se usara para indivar que las palabras seran procesada al usar UTF8 y con esto se asegura
        // que si el usaurio ingresa caracteres espaciales los modifique, además también reemplaza los espacios por +
        // que es otra forma de poder concatenar las palabras aparte del %20 indicada por el usauri
            var nombreLibroCodificado = URLEncoder.encode(nombreLibro, StandardCharsets.UTF_8);
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibroCodificado);
        System.out.println("Información manejada: " +json);
            if (json == null) {
                System.out.println("No se pudo obtener información del API.");
                return null;
            }
            //se guarda la información de resultados en la instnacia
        // de la clase data resultados, además de usar el conversor para indicar que la información json
        // es de tipo dataresultados
            DataResultBooks librosResultado = conversor.obtenerDatos(json, DataResultBooks.class);

            //Se valida que la información guardada en librosResultados no sea null
            if (librosResultado.results() == null || librosResultado.results().isEmpty()) {
                System.out.println("No se encontraron libros con ese nombre.");
                return null;
            }



            return librosResultado;

    }

    private void buscarLibroPorTitulo( ) {

        System.out.print("Ingresa el libro que quieras buscar: ");
        //Variable que guarda la información ingresada por el usuario
        var infousuario = teclado.nextLine();
        //Se instancia y llama al método obtener libros
         infoBook = getDatosBook(infousuario);
         //Se crea una instancia para poder manejar el proceso de guardado
        Book libroAguardar;

        /**
         * Método para realizar la busqueda de un libro por su titulo
         * busca 1 elemento a la vez
         * Se usa la lista de libros obtenidos con la función getDatosBook
         * además de usar el stream para filtrar la información como
         * también convertir esta con map en nuevos datos de tipo Book
         * */
        Optional<Book> libroCambios = infoBook.results().stream()
                .filter(b -> b.title().toUpperCase().contains(infousuario.toUpperCase()))
                .findFirst()
                .map(dataBook -> new Book(
                        dataBook.title(),
                        dataBook.authors().stream()
                                .map(a -> new Author(a.name(), a.birthYear(), a.deathYear()))
                                .collect(Collectors.toList()),
                        Language.fromString(
                                dataBook.languages().isEmpty() ? null : dataBook.languages().get(0)
                        ),
                        dataBook.downloadCount()
                ));
        // Ciclo if para validar si el libro esta
        if (libroCambios.isPresent()) {
            System.out.println("Libro Encontrado");
            System.out.println(libroCambios.get());
            libroAguardar = libroCambios.get();
            repositorioB.save(libroAguardar);
            //Guardar el libro en una lisa
            //datosBooks.add(libroAguardar);

        } else {
            System.out.println("Libro no encontrado: " + infousuario);
        }




    }

    private void listarLibrosRegistrados() {
        // primera forma para mostrar los datos guardados en una listadatosBooks.forEach(System.out::println);
        datosBooks = repositorioB.findAll();
        // para mostrar la información
        datosBooks.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        //Pipeline para poder cambiar la información de tipo libro a author filtrado
        //Solo la ifnormación del autor
//     List<Author> converDatosAuthor  = datosBooks.stream().flatMap(book -> book.getAuthors().stream())
//             .map(infoAuthor -> new Author(
//                     infoAuthor.getName(),
//                     infoAuthor.getBirthYear(),
//                     infoAuthor.getDeathYear()
//             ))
//             .collect(Collectors.toList());
//
//      authorsRegistry.addAll(converDatosAuthor);
//
//      authorsRegistry.forEach(System.out::println);

        authorsRegistry = repositorioA.findAll();
        authorsRegistry.forEach(System.out::println);



    }







}
