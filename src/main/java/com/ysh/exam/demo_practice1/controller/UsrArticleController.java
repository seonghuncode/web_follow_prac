package com.ysh.exam.demo_practice1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysh.exam.demo_practice1.service.ArticleService;
import com.ysh.exam.demo_practice1.vo.Article;

@Controller
public class UsrArticleController {

	private ArticleService articleService;

	public UsrArticleController(ArticleService articleService) {
		this.articleService = articleService;
	} // 생성자를 만들어 주입해도 되고 @Autowired를 사용해도 된다

	
	
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}
	
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public Article getArtice(int id) {
		return articleService.getArticle(id);
	}
	
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 존재 하지 않습니다.";
		}
		articleService.doDelete(id);
		return id + "번 게시물이 삭제 되었 습니다.";
		
	}
	
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(int id, String title, String body) {
		Article article = articleService.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 존재 하지 않습니다.";
		}
		articleService.doModify(id, title, body);
		return id + "게시물을 수정 했습니다.";
	}
	
	

	
	
	

}
