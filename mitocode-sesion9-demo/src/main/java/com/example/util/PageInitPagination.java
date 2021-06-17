package com.example.util;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.example.entities.Article;
import com.example.service.ArticleService;


@Component
public class PageInitPagination {

	@Autowired
	private ArticleService articleService;

	// pagination
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10 };

	public  ModelAndView initPagination(Optional<Integer> pageSize, Optional<Integer> page, String url) {
		ModelAndView initModelView = new ModelAndView(url);
		
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;

		Page<Article> articlesList = articleService.findAll(PageRequest.of(evalPage, evalPageSize));
		PagerModel pager = new PagerModel(articlesList.getTotalPages(), articlesList.getNumber(), BUTTONS_TO_SHOW);

		initModelView.addObject("articlesList", articlesList);
		initModelView.addObject("selectedPageSize", evalPageSize);
		initModelView.addObject("pageSizes", PAGE_SIZES);
		initModelView.addObject("pager", pager);
		return initModelView;
	}

}