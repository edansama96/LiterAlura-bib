package com.bibliotec.LiterAlura_bib.literAlura.primal;

import com.bibliotec.LiterAlura_bib.literAlura.service.ConsumoApi;

import java.util.Scanner;

/**
 * Clase principal que permitira interactuar con l usuario atravez de un menu
 * se configuran los métodos necesarios para la aplicación
 *
 * */
public class Primal {
    private Scanner teclado = new Scanner(System.in);

    private ConsumoApi consumoApi = new ConsumoApi();
    //Variable que maneja la información constante de la URI del api
    private final String URL_BASE = "https://gutendex.com/books?";
    //Método utilizado para crear el menu de la aplicación
    // en donde este funcionara por consola
    public void  showTheMenu(){
        System.out.println("Por favor ingrese el nombre del Book");
        var nombreAuthor = teclado.nextLine();
//        var opcion = -1;
//        while(opcion != 0){
//            var menu = """
//                1 - Buscar Series
//                2 - Buscar Episodios
//                3 - Mostrar Series buscadas
//                4 - Buscar Series por título
//                5 - Top 5 Mejores Series
//                6 - Buscar Series por categoria
//                7 - Filtrar series por una cantidad de temporadas y evaluación
//                8 - Buscar episodios por nombre o título
//                9 - Top 5 episodios por serie
//                0-salir
//                """;
//            System.out.println(menu);
//            opcion = teclado.nextInt();
//            teclado.nextLine();
//
//            switch (opcion){
//                case 1:
//                    buscarSerieWeb();
//                    break;
//                case 2:
//                    buscarEpisodioPorSerie();
//                    break;
//                case 3:
//                    mostrarSeriesBuscadas();
//                    break;
//                case 4:
//                    buscarSeriePorTitulo();
//                    break;
//                case 5 :
//                    buscarTop5Series();
//                    break;
//                case 0:
//                    System.out.println("Cerrando la aplicación...");
//                    break;
//                default:
//                    System.out.println("Opción inválida");
//                    break;
//            }
//        }


    }

}
