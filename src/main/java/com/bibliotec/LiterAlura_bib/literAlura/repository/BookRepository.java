package com.bibliotec.LiterAlura_bib.literAlura.repository;

import com.bibliotec.LiterAlura_bib.literAlura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book, Long>{
}
