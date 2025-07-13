package com.bibliotec.LiterAlura_bib.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResultBooks(

        @JsonAlias("results")  List<DataBook> results) {
}
