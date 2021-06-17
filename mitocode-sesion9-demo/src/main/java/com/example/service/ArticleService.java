package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entities.Article;

public interface ArticleService {

	List<Article> getAllArticles();

	Article createArticle(Article article);

	Article updateArticle(Long id, Article article);

	void deleteArticle(Long articleId);

	Article findById(Long id);

	Article getLatestEntry();

	boolean titleAndAuthorValid(Article article);

	Page<Article> findAll(Pageable pageable);

}