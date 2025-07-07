package com.bibliotec.LiterAlura_bib.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Record para interpretar la información de la API relacionada a los libros.
 * Utiliza @JsonAlias para mapear correctamente los campos del JSON si el nombre difiere.
 * Esta estructura está pensada para recibir datos desde la API Gutendex.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBook(
        @JsonAlias("title")String title, // el nombre del campo es igual al del JSON, no se necesita @JsonAlias
        @JsonAlias("summaries") String summaries,
        @JsonAlias("languages") String languages,
        @JsonAlias("download_count") String downloadCount,
        @JsonAlias("authors") List<String> authors // puedes usar otro DTO si necesitas más detalle
) {
}
