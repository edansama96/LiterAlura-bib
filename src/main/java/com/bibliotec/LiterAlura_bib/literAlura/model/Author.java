package com.bibliotec.LiterAlura_bib.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Author {
     private String name;
   private  Integer birthYear;
    private  Integer deathYear;

    public Author(List<DataAuthor> authors) {
    }

    public Author(String name, Integer birthYear, Integer deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return

                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", deathYear=" + deathYear
                ;
    }
}
