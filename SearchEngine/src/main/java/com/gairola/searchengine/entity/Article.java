package com.gairola.searchengine.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity class representing an article.
 */
@Entity
@Table(name = "articles")
@Data
public class Article {

    /**
     * Unique identifier for the article.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /**
     * Title of the article.
     */
    @Column(name = "title")
    private String title;

    /**
     * Author of the article.
     */
    @Column(name = "author")
    private String author;

    /**
     * Content or body of the article.
     */
    @Column(name = "content")
    private String content;

    /**
     * Date when the article was published.
     */
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    /**
     * Category or topic of the article.
     */
    @Column(name = "category")
    private String category;

    /**
     * Keywords associated with the article.
     */
    @Column(name = "keywords")
    private String keywords;
}
