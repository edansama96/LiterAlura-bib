package com.bibliotec.LiterAlura_bib.literAlura.repository;

import com.bibliotec.LiterAlura_bib.literAlura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Long> {
    @Query("SELECT a FROM Author a WHERE a.birthYear <= :fecha AND (a.deathYear > :fecha OR a.deathYear IS NULL)")
    List<Author> findAutoresVivosEnAnio(@Param("fecha") Integer fecha);

}
