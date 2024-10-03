package com.gairola.searchengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gairola.searchengine.entity.Article;
import com.gairola.searchengine.service.ArticleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return articleService.getArticleById(uuid);
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable String id, @RequestBody Article article) {
        UUID uuid = UUID.fromString(id);
        return articleService.updateArticle(uuid, article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        articleService.deleteArticle(uuid);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Article>> searchArticles(@RequestParam String searchText) {
        List<Article> foundArticles = articleService.searchArticles(searchText);
        if (!foundArticles.isEmpty()) {
            return ResponseEntity.ok(foundArticles);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}