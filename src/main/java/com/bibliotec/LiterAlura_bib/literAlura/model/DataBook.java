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
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<DataAuthor> authors,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Integer downloadCount

) {
}
