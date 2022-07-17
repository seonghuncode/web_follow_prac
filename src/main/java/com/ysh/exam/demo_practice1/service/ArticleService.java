package com.ysh.exam.demo_practice1.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.ysh.exam.demo_practice1.repository.ArticleRepository;
import com.ysh.exam.demo_practice1.vo.Article;

@Service
public class ArticleService {
	

	private ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
		makeTestData();
	}
	

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	
	private void makeTestData() {
		for(int i = 1; i <= 10; i++) {
			String title = "title" + i;
			String body = "body" + i;
			writeArticle(title, body);
		}
	}


	public void writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		
	}


	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	
	
	
	
	
	
	
	
	
}
