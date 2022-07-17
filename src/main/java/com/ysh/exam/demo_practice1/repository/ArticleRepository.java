package com.ysh.exam.demo_practice1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ysh.exam.demo_practice1.vo.Article;

@Component
public class ArticleRepository {

	private List<Article> articles;
	private int lastId;
	
	public ArticleRepository() {
		lastId = 0;
		this.articles = new ArrayList<>();
	}

	public List<Article> getArticles() {
		return articles;
	}

	
	public void writeArticle(String title, String body) {
		int id = lastId + 1;
		Article article = new Article(id, title, body);
		articles.add(article);
		
		lastId = id;
		
	}

}
