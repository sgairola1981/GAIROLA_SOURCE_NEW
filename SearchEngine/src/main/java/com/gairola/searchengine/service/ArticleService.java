package com.gairola.searchengine.service;

import java.util.List;
import java.util.UUID;

import com.gairola.searchengine.entity.Article;

public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleById(UUID id);

    Article createArticle(Article article);

    Article updateArticle(UUID id, Article article);

    void deleteArticle(UUID id);

    List<Article> searchArticles(String searchText);
}