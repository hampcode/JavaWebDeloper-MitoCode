package com.hampcode.pagination;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;

	private int totalPages;

	private int numElementsByPage;

	private int currentPage;

	private List<PageItem> pages;

	public PageRender(String url, Page<T> page) {
		this.url = url;
		this.page = page;
		this.pages = new ArrayList<PageItem>();

		numElementsByPage = page.getSize();
		totalPages = page.getTotalPages();
		currentPage = page.getNumber() + 1;

		int from, to;
		if (totalPages <= numElementsByPage) {
			from = 1;
			to = totalPages;
		} else {
			if (currentPage <= numElementsByPage / 2) {
				from = 1;
				to = numElementsByPage;
			} else if (currentPage >= totalPages - numElementsByPage / 2) {
				from = totalPages - numElementsByPage + 1;
				to = numElementsByPage;
			} else {
				from = currentPage - numElementsByPage / 2;
				to = numElementsByPage;
			}
		}

		for (int i = 0; i < to; i++) {
			pages.add(new PageItem(from + i, currentPage == i+1 ? true:false));
		}

	}

	public String getUrl() {
		return url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<PageItem> getPages() {
		return pages;
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public boolean isHasNext() {
		return page.hasNext();
	}

	public boolean isHasPrevious() {
		return page.hasPrevious();
	}

}