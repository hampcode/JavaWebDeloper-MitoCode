package com.example.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.entities.Article;
import com.example.service.ArticleService;
import com.example.util.PageInitPagination;

@Controller
@RequestMapping("/articles")
public class ArticleController {

	protected static final String ARTICLE_VIEW = "articles/showArticle"; // view template for single article
	protected static final String ARTICLE_ADD_FORM_VIEW = "articles/newArticle"; // form for new article
	protected static final String ARTICLE_EDIT_FORM_VIEW = "articles/editArticle"; // form for editing an article

	protected static final String ARTICLE_PAGE_VIEW = "articles/allArticles"; // list with pagination

	protected static final String INDEX_VIEW = "index"; // articles with pagination

	@Autowired
	private PageInitPagination pageInitiPagination;

	@Autowired
	private ArticleService articleService;

	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long articleId, Model model) {
		model.addAttribute("article", articleService.findById(articleId));
		return ARTICLE_VIEW;
	}

	@GetMapping
	public ModelAndView getAllArticles(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pageInitiPagination.initPagination(pageSize, page, ARTICLE_PAGE_VIEW);
		return modelAndView;
	}

	@GetMapping("/new")
	public String newArticle(Model model) {

		// in case of redirection model will contain article
		if (!model.containsAttribute("article")) {
			model.addAttribute("article", new Article());
		}
		return ARTICLE_ADD_FORM_VIEW;
	}

	@PostMapping("/create")
	public String createArticle(@Valid Article article, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors() || articleService.titleAndAuthorValid(article) == false) {

			// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
			attr.addFlashAttribute("article", article);

			attr.addFlashAttribute("error", "No se permite articulos con el mismo titulo y autor");

			return "redirect:/articles/new";
		}
		Article newArticle = articleService.createArticle(article);
		model.addAttribute("article", newArticle);

		return "redirect:/articles/" + newArticle.getArticleId();
	}

	@GetMapping("{id}/edit")
	public String editArticle(@PathVariable(value = "id") Long articleId, Model model) {
		/*
		 * in case of redirection from '/article/{id}/update' model will contain article
		 * with field values
		 */
		if (!model.containsAttribute("article")) {
			model.addAttribute("article", articleService.findById(articleId));
		}
		return ARTICLE_EDIT_FORM_VIEW;
	}

	@PostMapping(path = "/{id}/update")
	public String updateArticle(@PathVariable(value = "id") Long articleId, @Valid Article articleDetails,
			BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors() || articleService.titleAndAuthorValid(articleDetails) == false) {

			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
			attr.addFlashAttribute("article", articleDetails);

			attr.addFlashAttribute("error", "No se permite articulos con el mismo titulo y autor");

			return "redirect:/articles/" + articleDetails.getArticleId() + "/edit";
		}

		articleService.updateArticle(articleId, articleDetails);
		model.addAttribute("article", articleService.findById(articleId));
		return "redirect:/articles/" + articleId;
	}

	@GetMapping(value = "/{id}/delete")
	public String deleteArticle(@PathVariable("id") Long articleId) {
		// Article article = articleService.findById(articleId);
		// String title = article.getTitle();
		articleService.deleteArticle(articleId);
		return "redirect:/articles";
	}

}