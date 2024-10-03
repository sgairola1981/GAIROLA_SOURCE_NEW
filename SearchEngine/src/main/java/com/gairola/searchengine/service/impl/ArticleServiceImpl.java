package com.gairola.searchengine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gairola.searchengine.entity.Article;
import com.gairola.searchengine.repository.ArticleRepository;
import com.gairola.searchengine.service.ArticleService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article getArticleById(UUID id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(UUID id, Article article) {
        Optional<Article> existingArticleOptional = articleRepository.findById(id);
        if (existingArticleOptional.isPresent()) {
            Article existingArticle = existingArticleOptional.get();
            existingArticle.setTitle(article.getTitle());
            existingArticle.setAuthor(article.getAuthor());
            existingArticle.setContent(article.getContent());
            existingArticle.setPublicationDate(article.getPublicationDate());
            existingArticle.setCategory(article.getCategory());
            existingArticle.setKeywords(article.getKeywords());
            return articleRepository.save(existingArticle);
        } else {
            return null;
        }
    }

    @Override
    public void deleteArticle(UUID id) {
        articleRepository.deleteById(id);
    }

    @Override
    public List<Article> searchArticles(String searchText) {
        return articleRepository.findArticlesBySearchText(searchText);
    }
}