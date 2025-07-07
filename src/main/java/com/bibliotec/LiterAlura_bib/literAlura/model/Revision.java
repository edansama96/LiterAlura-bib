package com.bibliotec.LiterAlura_bib.literAlura.model;

public class Revision {

   public static void Revis(){
//       //Se le solicita al usuario  el nombre del elemento a buscar
//       System.out.println("Por favor escribe el nombre de la serie que deseas buscar: ");
////Se establece una variable la cual guardara la información indicada por el usuario
//// para este caso es de tipo String
//       var nombreSerie = tecalado.nextLine();
//
////Se cargara el archivo config.properties
//// se usa un try en caso de encontrar un problema al cargar el archivo
//       try {
//           //abre el archivo que se utilizara
//           FileInputStream inputStream = new FileInputStream("target/classes/config.properties");
//           //Se lee e interpreta la información del archivo
//           properties.load(inputStream);
//           // se obtendra la clave apikey
//           API_KEY = properties.getProperty("api.key");
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       }
//
////se crear una variable de tipo String, la cual guarda el valor retornado por el
//// método ObtenerDatos
//       var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&apikey=" + API_KEY);
//
//// se realizara la conversión usando la variable de la clase conversorDatos instanciada
//       var datos = conversor.obtenerDatos(json, DatosSerie.class);
////Sout que permite obtener el título, totalTemporadas y evaluación
//       System.out.println(datos);
//       Integer total = datos.totalTemporadas();
//// validando que la conversión funcionara bien
////System.out.println("Los datos son: "+datos.totalTemporadas());
//
////Creación de la lista para guardar los episodios de cada capitulos
////Busca los datos de todas las temporadas
//       List<DatosTemporadas> temporadas = new ArrayList<>();
//       for (int i = 1; i <= total; i++) {
//           //nueva uri utilizada para poder buscar y guardar todos los episodios en cada uno de las temporadas al usar el iterador i
//           json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season=" + i + "&apikey=" + API_KEY);
//           //Variable que se encarga de obtener y convertir al información de tipo Json a tipo DatosTemporada
//           var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
//           // Se adicciona la infromación de cada temporada en la lista
//           temporadas.add(datosTemporadas);
       //}

   }
}
