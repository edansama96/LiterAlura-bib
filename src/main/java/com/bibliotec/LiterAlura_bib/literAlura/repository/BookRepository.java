package com.bibliotec.LiterAlura_bib.literAlura.repository;

import com.bibliotec.LiterAlura_bib.literAlura.model.Book;
import com.bibliotec.LiterAlura_bib.literAlura.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <Book, Long>{

   List<Book> findByLanguages(Language language);

}
