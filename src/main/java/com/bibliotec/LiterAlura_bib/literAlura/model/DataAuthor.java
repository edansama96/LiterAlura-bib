package com.bibliotec.LiterAlura_bib.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Clase record que representa los datos básicos de un autor recibidos desde una API externa,
 * como Gutendex. Se usa principalmente para mapear automáticamente el JSON que contiene
 * la información del autor.
 *
 * Uso de anotaciones:
 * - @JsonIgnoreProperties(ignoreUnknown = true): Ignora cualquier campo adicional del JSON
 *   que no esté definido en este record. Esto previene errores si la API cambia o envía
 *   más información de la necesaria.
 *
 * - @JsonAlias("birth_year") y @JsonAlias("death_year"): Permiten mapear campos del JSON
 *   que tienen nombres diferentes a los usados en el record (por ejemplo, "birth_year" del JSON
 *   se convierte en birthYear en Java).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataAuthor(
        @JsonAlias("name") String name,
        @JsonAlias("birth_year") Integer birthYear,
        @JsonAlias("death_year") Integer deathYear
) {}
