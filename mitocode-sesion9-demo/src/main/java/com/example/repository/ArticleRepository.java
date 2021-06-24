package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entities.Article;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

	@Query(value = "SELECT MAX(id) FROM Article")
	Long findTopByOrderByIdDesc();

	@Query("SELECT a FROM Article a WHERE a.title=:title and a.author=:author")
	List<Article> findByTitleAndAuthor(@Param("title") String title, @Param("author") String author);

	//@Query("SELECT a FROM Article a WHERE a.title=?1")
	List<Article> findByTitleContaining(String title);
	
	Page<Article> findAll(Pageable pageable);

}
