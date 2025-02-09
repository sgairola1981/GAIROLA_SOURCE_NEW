package com.gairola.searchengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gairola.searchengine.entity.Article;

import java.util.List;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {

    @Query("SELECT a FROM Article a WHERE " +
            "LOWER(a.content) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.title) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.author) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.category) LIKE LOWER(CONCAT('%', :searchText, '%')) OR " +
            "LOWER(a.keywords) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Article> findArticlesBySearchText(@Param("searchText") String searchText);

    List<Article> findByAuthor(String author);

    List<Article> findByTitle(String title);

    List<Article> findByCategory(String category);
}