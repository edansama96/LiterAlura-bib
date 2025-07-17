package com.bibliotec.LiterAlura_bib.literAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Book {

    private String title;
    private List<DataAuthor> authors;
    private Language languages;
    private Integer downloadCount;



    public Book(String title, List<DataAuthor> authors, Language languages, Integer downloadCount) {
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.downloadCount = downloadCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DataAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<DataAuthor> authors) {
        this.authors = authors;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", languages=" + languages +
                ", downloadCount=" + downloadCount;
    }
}
